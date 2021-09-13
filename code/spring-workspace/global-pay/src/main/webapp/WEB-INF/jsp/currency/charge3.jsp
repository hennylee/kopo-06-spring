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
				<!-- <div class="col-6 text-end">
							<button class="btn btn-primary btn-lg active" role="button" aria-pressed="true" onclick="gotoNext()">
								다음단계
							</button>
						</div> -->
			</div>
		</div>
		
		
		<!--  
		
			private int no;
			private String accountNo;
			private String accountBank;
			private String date;
			private String currencyCode;
			private double krAmount;
			private String cardNo;
			private double exchangeRate;
			private double feAmount;
		
		-->
		
		<div class="card-body pt-4 p-3">
             <ul class="list-group">
               <li class="list-group-item border-0 d-flex p-4 mb-2 bg-gray-100 border-radius-lg">
                 <div class="d-flex flex-column">
                   <h6 class="mb-3 text-sm">${chargeHistory.currencyCode } 충전 내역</h6>
                   <span class="mb-2 text-xs">충전 금액 : <span class="text-dark font-weight-bold ms-sm-2"> + ${chargeHistory.feAmount }</span></span>
                   <span class="mb-2 text-xs">충전 후 잔액 : <span class="text-dark font-weight-bold ms-sm-2">${balance }</span></span>
                   <span class="mb-2 text-xs">출금 계좌 : <span class="text-dark ms-sm-2 font-weight-bold">${chargeHistory.accountBank } | ${chargeHistory.accountNo }</span></span>
                   <span class="mb-2 text-xs">출금 금액 : <span class="text-dark ms-sm-2 font-weight-bold">${chargeHistory.krAmount }</span></span>
                 </div>
                 <div class="ms-auto text-end">
                   <a class="btn btn-link text-danger text-gradient px-3 mb-0" href="javascript:;"><i class="far fa-bullet-list-67 me-2"></i>Delete</a>
                 </div>
               </li>
             </ul>
	</div>
	</div>
</div>