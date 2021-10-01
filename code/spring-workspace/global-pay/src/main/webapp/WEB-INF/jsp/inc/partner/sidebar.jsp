<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>   
 
		<div id="sidebar" class="active">
            <div class="sidebar-wrapper active">
                <div class="sidebar-header">
                    <div class="d-flex justify-content-between">
                        <div class="logo">
                            <a href="${path }/partner"><img src="${path }/resources/assets/manager/images/logo/logo.png" alt="Logo" srcset=""></a>
                        </div>
                        <div class="toggler">
                            <a href="#" class="sidebar-hide d-xl-none d-block"><i class="bi bi-x bi-middle"></i></a>
                        </div>
                    </div>
                </div>
                <div class="sidebar-menu">
                    <ul class="menu">
                    	<li class="sidebar-item  has-sub">
                            <a href="#" class='sidebar-link'>
                                <i class="bi bi-stack"></i>
                                <span>상품 관리</span>
                            </a>
                            <ul class="submenu ">
                                <li class="submenu-item ">
                                    <a href="${path }/partner/product/upload">단일 상품 등록</a>
                                </li>
                                <li class="submenu-item ">
                                    <a href="${path }/partner/product/upload-mass">대량 상품 등록</a>
                                </li>
                            </ul>
                         </li>
                         
                         <li class="sidebar-item  has-sub">
                            <a href="#" class='sidebar-link'>
                                <i class="bi bi-stack"></i>
                                <span>매출 관리</span>
                            </a>
                            <ul class="submenu ">
                                <li class="submenu-item ">
                                    <a href="${path }/admin/currency">매출 조회</a>
                                </li>
                            </ul>
                         </li>
                    
                    
                    
                    	<li class="sidebar-item  has-sub">
                            <a href="#" class='sidebar-link'>
                                <i class="bi bi-stack"></i>
                                <span>프로모션</span>
                            </a>
                            <ul class="submenu ">
                                <li class="submenu-item ">
                                    <a href="${path }/admin/currency">프로모션 신청</a>
                                </li>
                                <li class="submenu-item ">
                                    <a href="${path }/admin/currency">신청내역 조회</a>
                                </li>
                            </ul>
                         </li>
                        <li class="sidebar-title">Menu</li>

                        

                    </ul>
                </div>
                <button class="sidebar-toggler btn x"><i data-feather="x"></i></button>
            </div>
        </div>