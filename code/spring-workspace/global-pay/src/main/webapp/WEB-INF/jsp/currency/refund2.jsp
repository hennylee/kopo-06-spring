<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<script>

// 전역변수
let curRate
let curSpread
let wonAmount
let currencyAmount
let connectedAccount

$(document).ready(function(){
	cardNo = '${cardNo}';
	currencySellChart();
	checkInput();
});


// 2단계 페이지 차트 만들기
function currencySellChart(){
	
	// json객체로 변경
	let json = JSON.parse('${json}')
	
	// 차트 내용 설정
	let regDates = new Array();
	let cashSellRates = new Array();
	let cashSellSpreads = new Array();

	$.each( json, function(key, value){
    	regDates.push(value.regDate);
    	cashSellRates.push(value.cashSellRate);
    	cashSellSpreads.push(value.cashSellSpread);
	});
	
	let len = json.length;
	curRate = cashSellRates[len - 1]
	curSpread = cashSellSpreads[len - 1]
	
	 // 차트 삽입
	var ctx3 = document.getElementById("chart-sell-currency").getContext("2d");

	var gradientStroke1 = ctx3.createLinearGradient(0, 230, 0, 50);

	gradientStroke1.addColorStop(1, 'rgba(203,12,159,0.2)');
	gradientStroke1.addColorStop(0.2, 'rgba(72,72,176,0.0)');
	gradientStroke1.addColorStop(0, 'rgba(203,12,159,0)'); //purple colors

	var gradientStroke2 = ctx3.createLinearGradient(0, 230, 0, 50);

	gradientStroke2.addColorStop(1, 'rgba(20,23,39,0.2)');
	gradientStroke2.addColorStop(0.2, 'rgba(72,72,176,0.0)');
	gradientStroke2.addColorStop(0, 'rgba(20,23,39,0)'); //purple colors

	new Chart(ctx3, {
	  type: "line",
	  data: {
	    labels: regDates,
	    datasets: [
	      {
	        label: "현금 팔때 가격",
  	        tension: 0.4, 
	        borderWidth: 0,
	        pointRadius: 0,
	        borderColor: "#cb0c9f",
	        borderWidth: 3,
	        backgroundColor: gradientStroke1,
	        fill: true,
	        data: cashSellRates,
	        maxBarThickness: 6

	      }
	    ],
	  },
	  options: {
	    responsive: true,
	    maintainAspectRatio: false,
	    plugins: {
	      legend: {
	        display: false,
	      }
	    },
	    interaction: {
	      intersect: false,
	      mode: 'index',
	    },
	    scales: {
	      y: {
	        grid: {
	          drawBorder: false,
	          display: true,
	          drawOnChartArea: true,
	          drawTicks: false,
	          borderDash: [5, 5]
	        },
	        ticks: {
	          display: true,
	          padding: 10,
	          color: '#b2b9bf',
	          font: {
	            size: 11,
	            family: "Open Sans",
	            style: 'normal',
	            lineHeight: 2
	          },
	        }
	      },
	      x: {
	        grid: {
	          drawBorder: false,
	          display: false,
	          drawOnChartArea: false,
	          drawTicks: false,
	          borderDash: [5, 5]
	        },
	        ticks: {
	          display: true,
	          color: '#b2b9bf',
	          padding: 20,
	          font: {
	            size: 11,
	            family: "Open Sans",
	            style: 'normal',
	            lineHeight: 2
	          },
	        }
	      },
	    },
	  },
	});
	
}

//입력한 금액 & 계좌 확인
function checkInput() {
	
	// 입력한 금액 확인
	$("#refund-input").keyup (function(e){
		// refund-input
		let refund = $("#refund-input").val();
		let won = refund * curRate;
		
		// #won-input
		$("#won-input").val(won);
		
		wonAmount = $("#won-input").val();
		currencyAmount = $("#refund-input").val();
	});
	
	
	// 선택한 계좌 확인
	$('#connectedAccountSelect').on('change', function(){
		
		if($('#connectedAccountSelect option:selected').val() !== 'null'){
			connectedAccount = $('#connectedAccountSelect option:selected').val();
		}
		
	});
}


//3단계 페이지로 이동
function gotoThird(){
	
	if(isNotNull(wonAmount) && isNotNull(connectedAccount)){
		
		
		wonAmount = wonAmount * -1
		currencyAmount = currencyAmount * -1
		
		console.log(wonAmount)
		console.log(currencyAmount)
		console.log(connectedAccount)
		console.log(selectedCurrencyEn)
		console.log(curRate)
		console.log(cardNo)
		
		
		$.ajax({ 
			url :  "${pageContext.request.contextPath}/refund3"
			, type : "post"
			, data : {
				krAmount : wonAmount
				, feAmount : currencyAmount
				, connectedAccount : connectedAccount
				, currencyEn : selectedCurrencyEn
				, exchangeRate : curRate
				, cardNo : cardNo
			}
			, success : thirdPage
			, error : function(){
				alert("Ajax Error")
			}
		});
	}
	
}

//3단계 페이지 로딩
function thirdPage(result){
	$('#refundStep_2').replaceWith(result);
}

</script>    
    
 	<div class="row mt-4" id="refundStep_2">
 		<div class="col mt-4">
			<div class="card h-100">
	  			<div class="card-header pb-0 p-3">
					<div class="row">
						<div class="col-6 d-flex align-items-center">
							<h4 class="font-weight-bolder">2단계 : 충전 금액 및 계좌 선택</h4>
						</div>
						<div class="col-6 text-end">
							<button class="btn btn-primary btn-lg active" role="button" aria-pressed="true" onclick="gotoThird()">
								다음단계
							</button>
						</div>
					</div>
	  			</div>
	  			<div class="card-body p-3">
	  				<form>
			  			<div class="row">
			  				<div class="col">
			  					<h6>
				  					<span id="selectedNation2"></span>의 현재 환불 환율
			  					</h6>
								<div class="chart">
									<canvas id="chart-sell-currency" class="chart-canvas" height="300"></canvas>
								</div>
							</div>
		  					<div class="col">
		  						<div class="row">
			  						<div class="form-group">
					  					<div class="form-group">
									        <label for="example-text-input" class="form-control-label">신청금액</label>
									        <span id="input-limit"></span>
									        <input class="form-control" type="text" 
									        	placeholder="환불할 금액을 입력하세요." id="refund-input">
									    </div>
			  						</div>
		  						</div>
		  						<div class="row">
					  				<div class="form-group">
					  					<div class="form-group">
									        <label for="example-text-input" class="form-control-label">원화금액</label>
									        <input class="form-control" type="text"
									        	placeholder="환불될 원화 금액입니다."  id="won-input">
									    </div>
			  						</div>
		  						</div>
		  						<div class="row">
					  				<div class="form-group">
					  					<div class="form-group">
									        <label for="connectedAccountSelect">연결계좌</label>
									        <a type="button" class="btn btn-outline-primary btn-sm" 
									        	style="float: right;height: 2rem;"
									        	href="https://testapi.openbanking.or.kr/oauth/2.0/authorize?response_type=code&client_id=f07ebe18-950e-41d5-895d-d7588dac259d&redirect_uri=http://localhost:9997/global-pay/callback&scope=login inquiry transfer&state=b80BLsfigm9OokPTjy03elbJqRHOfGSY&auth_type=0">
									        	계좌 등록
									        </a>
										    <select multiple class="form-control" id="connectedAccountSelect">
										      <c:forEach var="accountVO" items="${accounts }">
											      <option>${accountVO.accountBank }&nbsp;&nbsp;&nbsp;${accountVO.accountNum }</option>
										      </c:forEach>
										      <c:if test="${empty accounts}">
										      	<option value="null">연결된 계좌가 없습니다.</option>
										      </c:if>
										    </select>
									    </div>
			  						</div>
		  						</div>
		  					</div>
			  			</div>
		  			</form>
	  			</div>
	  		</div>
		</div>
	</div>
