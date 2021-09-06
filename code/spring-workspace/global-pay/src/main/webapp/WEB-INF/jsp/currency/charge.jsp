<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!--
=========================================================
* Soft UI Dashboard - v1.0.3
=========================================================

* Product Page: https://www.creative-tim.com/product/soft-ui-dashboard
* Copyright 2021 Creative Tim (https://www.creative-tim.com)
* Licensed under MIT (https://www.creative-tim.com/license)

* Coded by Creative Tim

=========================================================

* The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
-->
<!DOCTYPE html>
<html lang="en">

<head>
  <jsp:include page="/WEB-INF/jsp/inc/common/head-content.jsp"/>
  <script src="${pageContext.request.contextPath }/resources/assets/js/plugins/chartjs.min.js"></script>
</head>

<script type="text/javascript">

let selectedNameKr
let selectedNameEn

function nullCheck(e){
	if(e == "" || e == null){
		return false
	}
	return true
}

// 화폐 단위 선택
function selectNation(btn){
	selectedNameKr = btn.innerText;
	selectedNameEn = btn.children.item(0).innerText;
	// 버튼 색깔 바꾸기 => 실패
}

function gotoSecond(){

	if(nullCheck(selectedNameEn)){
		$.ajax({ 
			url :  "${pageContext.request.contextPath}/charge"
			, type : "post"
			, data : {
				nationEn : selectedNameEn
			}
			, success : callback
			, error : function(){
				alert("Ajax Error")
			}
		});
	}
	
}

let curRate
let curSpread

function callback(result){

	// 차트 내용 설정
	let regDates = new Array();
	let cashBuyRates = new Array();
	let cashBuySpreads = new Array();

	$.each(result, function(key, value){
    	regDates.push(value.regDate);
    	cashBuyRates.push(value.cashBuyRate);
    	cashBuySpreads.push(value.cashBuySpread);
	});
	
	let len = result.length;
	curRate = cashBuyRates[len - 1]
	curSpread = cashBuySpreads[len - 1]
	
	console.log(curRate)
	console.log(curSpread)
	
	// 2단계 시작
	$('#selectedNation').text(selectedNameKr)
	$('#firstStep').hide();
	$('#secondStep').show();
	
	// 차트 삽입
	var ctx3 = document.getElementById("chart-nation-currency").getContext("2d");

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
	        label: "현금 살때 가격",
  	        tension: 0.4, 
	        borderWidth: 0,
	        pointRadius: 0,
	        borderColor: "#cb0c9f",
	        borderWidth: 3,
	        backgroundColor: gradientStroke1,
	        fill: true,
	        data: cashBuyRates,
	        maxBarThickness: 6

	      }/* ,
	      {
	        label: "현금 살때 수수료",
	        tension: 0.4,
	        borderWidth: 0,
	        pointRadius: 0,
	        borderColor: "#3A416F",
	        borderWidth: 3,
	        backgroundColor: gradientStroke2,
	        fill: true,
	        data: cashBuySpreads,
	        maxBarThickness: 6
	      }, */
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
	
	$("#won-input").keyup (function(e){
		let won = $("#won-input").val();
		let exchange = won * curRate;
		
		$("#exchange-input").val(exchange);
	});
	
}

</script>




<body class="g-sidenav-show  bg-gray-100">

  <jsp:include page="/WEB-INF/jsp/inc/common/header.jsp"/>

  <!-- aside start -->
  <jsp:include page="/WEB-INF/jsp/inc/dash-board/aside.jsp"/>
  <!-- aside end -->
  
  
  
  <main class="main-content position-relative max-height-vh-100 h-100 mt-1 border-radius-lg ">
    <!-- Navbar -->
    <jsp:include page="/WEB-INF/jsp/inc/dash-board/navbar.jsp"/>
    <!-- End Navbar -->
    
    
    
    
    
<!-- Start container -->
	<div class="container-fluid py-4">
	
<!-- 충전 1단계 -->
	  <div class="row" id="firstStep">
	  		<div class="card h-100">
	  			<div class="card-header pb-0 p-3">
					<div class="row">
						<div class="col-6 d-flex align-items-center">
							<h4 class="font-weight-bolder">1단계 : 충전외화 선택</h4>
						</div>
						<div class="col-6 text-end">
							<button class="btn btn-primary btn-lg active" role="button" aria-pressed="true" onclick="gotoSecond()">
								다음단계
							</button>
						</div>
					</div>
	  			</div>
	  			<div class="card-body p-3">
	  				<c:forEach var="nation" items="${nationList }">
		  				<button type="button" class="btn btn-secondary" style="width: 10rem;height: 4rem;" 
		  						onclick="selectNation(this)">
		  					${nation.nameKr }
		  					<h6>${nation.nameEn }</h6>
		  				</button>
	  				</c:forEach>
	  			</div>
	  			
	  		</div>
	    </div>

<!-- 충전 2단계 -->
	  	<div class="row" id="SencondStep">
	  		<div class="card h-100">
	  			<div class="card-header pb-0 p-3">
					<div class="row">
						<div class="col-6 d-flex align-items-center">
							<h4 class="font-weight-bolder">2단계 : 충전 금액 선택</h4>
						</div>
						<div class="col-6 text-end">
							<button class="btn btn-primary btn-lg active" role="button" aria-pressed="true" onclick="gotoNext()">
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
				  					<span id="selectedNation"></span>의 현재 환율
			  					</h6>
								<div class="chart">
									<canvas id="chart-nation-currency" class="chart-canvas" height="300"></canvas>
								</div>
							</div>
		  					<div class="col">
		  						<div class="row">
			  						<div class="form-group">
					  					<div class="form-group">
									        <label for="example-text-input" class="form-control-label">신청금액</label>
									        <input class="form-control" type="text" 
									        	placeholder="환전할 금액을 입력하세요." id="won-input">
									    </div>
			  						</div>
		  						</div>
		  						<div class="row">
					  				<div class="form-group">
					  					<div class="form-group">
									        <label for="example-text-input" class="form-control-label">원화금액</label>
									        <input class="form-control" type="text"
									        	placeholder="결제될 원화 금액입니다."  id="exchange-input">
									    </div>
			  						</div>
		  						</div>
		  						<div class="row">
					  				<div class="form-group">
					  					<div class="form-group">
									        <label for="exampleFormControlSelect2">연결계좌</label>
									        <a href="https://testapi.openbanking.or.kr/oauth/2.0/authorize?response_type=code&client_id=f07ebe18-950e-41d5-895d-d7588dac259d&redirect_uri=http://localhost:9997/global-pay/callback&scope=login inquiry transfer&state=b80BLsfigm9OokPTjy03elbJqRHOfGSY&auth_type=0">계좌 등록</a>
										    <select multiple class="form-control" id="exampleFormControlSelect2">
										      <option>1</option>
										      <option>2</option>
										      <option>3</option>
										      <option>4</option>
										      <option>5</option>
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
      
      <!-- footer start -->
  	  <jsp:include page="/WEB-INF/jsp/inc/dash-board/footer.jsp"/>
      <!-- footer end -->

    </div>
  </main>
  
  
  <!-- fixed-plugin start -->
  <jsp:include page="/WEB-INF/jsp/inc/dash-board/fixed-plugin.jsp"/>
  <!-- fixed-plugin end -->

  
  
  <!--   Core JS Files  start -->
   <jsp:include page="/WEB-INF/jsp/inc/common/script.jsp"/>
  <!--   Core JS Files  end -->
  
 

</body>
</html>