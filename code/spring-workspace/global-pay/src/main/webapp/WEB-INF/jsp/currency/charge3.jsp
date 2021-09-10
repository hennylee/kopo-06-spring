<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 충전 3단계 -->
	  	<div class="row" id="ThirdStep">
	  		<div class="card h-100">
	  			<div class="card-header pb-0 p-3">
					<div class="row">
						<div class="col-6 d-flex align-items-center">
							<h4 class="font-weight-bolder">3단계 : 충전 완료</h4>
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
										    <select multiple class="form-control" id="connectedAccountSelect">
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