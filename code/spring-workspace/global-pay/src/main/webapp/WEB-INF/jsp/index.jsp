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

<body class="g-sidenav-show  bg-gray-100">

  <!-- Navbar -->
  <jsp:include page="/WEB-INF/jsp/inc/main/navbar.jsp"/>
  <!-- End Navbar -->
  
  
  
  
  
  
  <section class="min-vh-100 mb-8">
  
  
  
  
  	<!-- Start 상단 title -->
    <div class="page-header align-items-start min-vh-50 pt-5 pb-11 m-3 border-radius-lg" style="background-image: url('${pageContext.request.contextPath}/resources/assets/img/curved-images/curved14.jpg');">
      <span class="mask bg-gradient-dark opacity-6"></span>
      <div class="container">
        <div class="row justify-content-center">
          <div class="col-lg-5 text-center mx-auto">
            <h1 class="text-white mb-2 mt-5">Hana Global Pay !</h1>
            <p class="text-lead text-white">해외직구는 하나 글로벌 페이와 함께</p>
          </div>
        </div>
      </div>
    </div>
    <!-- End 상단 title -->
    
    
    
    
    
    
<!-- Start Container -->
    <div class="container">
      <div class="row mt-lg-n10 mt-md-n11 mt-n10">
        <div class="col-xl-4 col-lg-5 col-md-7 mx-auto">
          <div class="card z-index-0">
            <div class="card-header text-center pt-4">
              <h5>메인 페이지 : ${userName} | ${userId }</h5>
            </div>
            
            
            <div class="card-body">
              <form role="form text-left">
                <div class="mb-3">
                  <input type="text" class="form-control" placeholder="Name" aria-label="Name" aria-describedby="email-addon">
                </div>
                <div class="mb-3">
                  <input type="email" class="form-control" placeholder="Email" aria-label="Email" aria-describedby="email-addon">
                </div>
                <div class="mb-3">
                  <input type="password" class="form-control" placeholder="Password" aria-label="Password" aria-describedby="password-addon">
                </div>
                <div class="form-check form-check-info text-left">
                  <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault" checked>
                  <label class="form-check-label" for="flexCheckDefault">
                    I agree the <a href="javascript:;" class="text-dark font-weight-bolder">Terms and Conditions</a>
                  </label>
                </div>
                <div class="text-center">
                  <button type="button" class="btn bg-gradient-dark w-100 my-4 mb-2">Sign up</button>
                </div>
                <p class="text-sm mt-3 mb-0">Already have an account? <a href="javascript:;" class="text-dark font-weight-bolder">Sign in</a></p>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
<!-- End Container -->   
    
    
    
  </section>
  
  
  
  
  
  <!-- -------- START FOOTER 3 w/ COMPANY DESCRIPTION WITH LINKS & SOCIAL ICONS & COPYRIGHT ------- -->
  <jsp:include page="/WEB-INF/jsp/inc/main/footer.jsp"/>
  <!-- -------- END FOOTER 3 w/ COMPANY DESCRIPTION WITH LINKS & SOCIAL ICONS & COPYRIGHT ------- -->




  <!--   Core JS Files   -->
  <jsp:include page="/WEB-INF/jsp/inc/common/script.jsp"/>
</body>

</html>