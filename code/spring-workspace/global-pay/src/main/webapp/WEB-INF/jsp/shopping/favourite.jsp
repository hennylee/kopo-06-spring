<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
    
    
      <!-- row start -->
      <div class="row">
          <div class="card h-100">
            <div class="card-header pb-0 px-3">
            	<div class="row">
					<div class="col-6 d-flex align-items-center">
						<h4 class="font-weight-bolder">찜목록</h4>
					</div>
				</div>
            </div>
            <div class="card-body pt-4 p-3">
              <ul class="list-group">
              
              	<c:forEach var="product" items="${list }">
	                <li class="list-group-item border-0 d-flex p-4 mb-2 bg-gray-100 border-radius-lg">
	                  <div class="d-flex flex-column">
	                  	<h6 class="mb-3 text-sm">${product.name }</h6>
	                  	<div class="d-flex px-2 py-1">
	                     <div>
	                       <img src="${product.img }" class="avatar avatar-xxl me-5" alt="user4">
	                     </div>
	                     <div class="d-flex flex-column justify-content-center"> 
	                     	<span class="mb-2 text-xs">가격 : 
	                    		<span class="text-dark ms-sm-2 font-weight-bold">
	                    		
	                    			<fmt:formatNumber value="${product.price }" pattern="#,###" />
	                    			&nbsp;${product.currency }
	                    		
	                    		</span>
	                    	</span>
	                       	<span class="mb-2 text-xs">브랜드 : <span class="text-dark font-weight-bold ms-sm-2">${product.brand }</span></span>
	                    	<span class="mb-2 text-xs">쇼핑몰 : <span class="text-dark ms-sm-2 font-weight-bold">${product }</span></span>
	                    	<span class="mb-2 text-xs">등록일 : <span class="text-dark ms-sm-2 font-weight-bold">${product.regDate }</span></span>
	                     </div>
	                   </div>
	                  </div>
	                  <div class="ms-auto text-end">
	                    <a class="btn btn-link text-danger text-gradient px-3 mb-0" href="javascript:;"><i class="far fa-trash-alt me-2"></i>Delete</a>
	                    <a class="btn btn-link text-dark px-3 mb-0" href="javascript:;"><i class="fas fa-pencil-alt text-dark me-2" aria-hidden="true"></i>Edit</a>
	                  </div>
	                </li>
                </c:forEach>
              </ul>
            </div>
        </div>
      
      
      <!-- footer start -->
  	  <jsp:include page="/WEB-INF/jsp/inc/dash-board/footer.jsp"/>
      <!-- footer end -->
      
      
	  </div>
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