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
<script type="text/javascript">
let selectedNation

function nullCheck(e){
	
	if(e == "" || e == null){
		return false
	}
	return true
}

// 화폐 단위 선택
function selectNation(btn){
	selectedNation = btn.children.item(0).innerText;
	// 버튼 색깔 바꾸기 => 실패
}

function gotoNext(){

	if(nullCheck(selectedNation)){
		$.ajax({ 
			url :  "${pageContext.request.contextPath}/charge2"
			, type : "post"
			, data : {
				nation : selectedNation
			}
			, success : callback
			, error : function(){
				alert("Ajax Error")
			}
		});
	}
	
}

function callback(result){
	$('#curStep').replaceWith(result);
	$('#selectedNation').text(selectedNation);
}
</script>

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
	
	  <div class="row" id="curStep">
	  		<div class="card h-100">
	  			<div class="card-header pb-0 p-3">
					<div class="row">
						<div class="col-6 d-flex align-items-center">
							<h4 class="font-weight-bolder">1단계 : 충전외화 선택</h4>
						</div>
						<div class="col-6 text-end">
							<button class="btn btn-primary btn-lg active" role="button" aria-pressed="true" onclick="gotoNext()">
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
	  			
	  			<div class="card-body p-3">
								  	챠트를 보여달라
								    <canvas id="chart-line" class="chart-canvas" height="300"></canvas>
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