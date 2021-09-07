<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
</head>


<script type="text/javascript">
function authorize() {
	
	
	let url = "https://testapi.openbanking.or.kr/oauth/2.0/authorize?"
			+"response_type=code"
			+"&client_id=f07ebe18-950e-41d5-895d-d7588dac259d"
			+"&redirect_uri=http://localhost:9997/global-pay/callback"
			+"&scope=login inquiry transfer"
			+"&state=b80BLsfigm9OokPTjy03elbJqRHOfGSY"
			+"&auth_type=0";
	
	window.open(url, "width=1200,height=900,scrollbars=yes,resizable=yes");
	
}

$(document).ready(function(){
	callbackURL = window.parent.document.URL;
	//alert(callbackURL)
	console.log(callbackURL)
	
	if(callbackURL.indexOf('callback') == -1){
		window.close();
	}
	
})

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
			<div class="row justify-content-md-center">
				<div class="col-6">
				
					<div class="card z-index-0">
						<div class="card-header text-center pt-4">
							<h5>카드 개설하기</h5>
						</div>


						<div class="card-body">
								<div class="text-center">
									<button 
										type="button"
										class="btn bg-gradient-dark w-100 my-4 mb-2"
										onclick="authorize()">계좌 본인 인증</button>
									<button 
										type="button"
										class="btn bg-gradient-dark w-100 my-4 mb-2"
										onclick="authorize()">SMS 본인 인증</button>
								</div>
						
								
							<form role="form text-left">
								<div class="mb-3">
									<input type="text" class="form-control" placeholder="Name"
										aria-label="Name" aria-describedby="email-addon">
								</div>
								<div class="mb-3">
									<input type="email" class="form-control" placeholder="Email"
										aria-label="Email" aria-describedby="email-addon">
								</div>
								<div class="mb-3">
									<input type="password" class="form-control"
										placeholder="Password" aria-label="Password"
										aria-describedby="password-addon">
								</div>
								<div class="form-check form-check-info text-left">
									<input class="form-check-input" type="checkbox" value=""
										id="flexCheckDefault" checked> <label
										class="form-check-label" for="flexCheckDefault"> I
										agree the <a href="javascript:;"
										class="text-dark font-weight-bolder">Terms and Conditions</a>
									</label>
								</div>
								<div class="text-center">
									<button type="button"
										class="btn bg-gradient-dark w-100 my-4 mb-2">Sign up</button>
								</div>
								<p class="text-sm mt-3 mb-0">
									Already have an account? <a href="javascript:;"
										class="text-dark font-weight-bolder">Sign in</a>
								</p>
							</form>
						</div>
					</div>
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