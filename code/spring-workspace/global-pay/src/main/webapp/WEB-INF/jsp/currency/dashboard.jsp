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
</head>

<body class="g-sidenav-show  bg-gray-100">

  <!-- aside start -->
  <jsp:include page="/WEB-INF/jsp/inc/dash-board/aside.jsp"/>
  <!-- aside end -->
  
  
  
  <main class="main-content position-relative max-height-vh-100 h-100 mt-1 border-radius-lg ">
    <!-- Navbar -->
    <jsp:include page="/WEB-INF/jsp/inc/dash-board/navbar.jsp"/>
    <!-- End Navbar -->
    
    
    
    
    
<!-- Start container -->
	<div class="container-fluid py-4">
	
	  <div class="row">
	  	<div class="col-12 col-xl-4">
	  		<div class="card h-100">
	  			<div class="card-header pb-0 p-3">
	  				<h6 class="mb-0">제목</h6>
	  			</div>
	  			<div class="card-body p-3">
	  				내용
	  			</div>
	  		</div>
	  	</div>
	  	<div class="col-12 col-xl-4">
	  		<div class="card h-100">
	  			<div class="card-header pb-0 p-3">
	  				<h6 class="mb-0">제목</h6>
	  			</div>
	  			<div class="card-body p-3">
	  				내용
	  			</div>
	  		</div>
	  	</div>
	  	<div class="col-12 col-xl-4">
	  		<div class="card h-100">
	  			<div class="card-header pb-0 p-3">
	  				<h6 class="mb-0">제목</h6>
	  			</div>
	  			<div class="card-body p-3">
	  				내용
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
  <jsp:include page="/WEB-INF/jsp/inc/dash-board/chartJS.jsp"/>
  <!--   Core JS Files  end -->
  
</body>

</html>