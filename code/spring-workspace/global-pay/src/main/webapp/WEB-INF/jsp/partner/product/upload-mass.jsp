<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>

<!DOCTYPE html>
<html lang="en">

<head>
	<jsp:include page="/WEB-INF/jsp/inc/partner/head-content.jsp"/>
	<link href="https://unpkg.com/filepond/dist/filepond.css" rel="stylesheet">
	<link href="https://unpkg.com/filepond-plugin-image-preview/dist/filepond-plugin-image-preview.css" rel="stylesheet">
</head>
<body>
    <div id="app">
        <jsp:include page="/WEB-INF/jsp/inc/partner/sidebar.jsp"/>
        
        <div id="main">
            <header class="mb-3">
                <a href="#" class="burger-btn d-block d-xl-none">
                    <i class="bi bi-justify fs-3"></i>
                </a>
            </header>

            <div class="page-heading">
                    <div class="page-title">
				        <div class="row">
				            <div class="col-12 col-md-6 order-md-1 order-last">
				                <h3>File Uploader</h3>
				                <p class="text-subtitle text-muted">File uploader that makes user easier to upload their files</p>
				            </div>
				            <div class="col-12 col-md-6 order-md-2 order-first">
				                <nav aria-label="breadcrumb" class="breadcrumb-header float-start float-lg-end">
				                    <ol class="breadcrumb">
				                        <li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
				                        <li class="breadcrumb-item active" aria-current="page">File Uploader</li>
				                    </ol>
				                </nav>
				            </div>
				        </div>
				    </div>
            </div>
            <div class="page-content">
		        <section class="section">
			        <div class="row">
			            <div class="col-12">
			                <div class="card">
			                    <div class="card-header">
			                        <h5 class="card-title">상품 대량 등록</h5>
			                    </div>
			                    <div class="card-content">
			                    	<form id="excelUploadForm" name="excelUploadForm" method="post" action="${path }/partner/product/excel" enctype="multipart/form-data">
				                        <div class="card-body">
				                            <p class="card-text">등록할 상품 목록을 양식에 맞는 
				                                <code>엑셀 파일로</code> 올려주세요.
				                            </p>
				                            <input type="file" id="excelFile" name="excelFile" >
				                            <button type="submit" class="btn btn-primary btn-block my-4 compose-btn">
		                                        엑셀 업로드
		                                    </button>
				                        </div>
			                        </form>
			                    </div>
			                </div>
			            </div>
			          </div>
			     </section>
            </div>

            
            
            <jsp:include page="/WEB-INF/jsp/inc/partner/footer.jsp"/>
            
        </div>
    </div>
    
    <jsp:include page="/WEB-INF/jsp/inc/partner/script.jsp"/>
</body>

</html>