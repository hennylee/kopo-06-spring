<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>   
 
		<div id="sidebar" class="active">
            <div class="sidebar-wrapper active">
                <div class="sidebar-header">
                    <div class="d-flex justify-content-between">
                        <div class="logo">
                            <a href="${path }/index.jsp"><img src="${path }/resources/assets/manager/images/logo/logo.png" alt="Logo" srcset=""></a>
                        </div>
                        <div class="toggler">
                            <a href="#" class="sidebar-hide d-xl-none d-block"><i class="bi bi-x bi-middle"></i></a>
                        </div>
                    </div>
                </div>
                <div class="sidebar-menu">
                    <ul class="menu">
                        <li class="sidebar-title">Menu</li>

                        <li class="sidebar-item active ">
                            <a href="https://zuramai.github.io/mazer/demo/index.html" class='sidebar-link'>
                                <i class="bi bi-grid-fill"></i>
                                <span>Dashboard</span>
                            </a>
                        </li>
                        
                         <li class="sidebar-item  has-sub">
                            <a href="#" class='sidebar-link'>
                                <i class="bi bi-stack"></i>
                                <span>환율 관리</span>
                            </a>
                            <ul class="submenu ">
                                <li class="submenu-item ">
                                    <a href="${path }/admin/currency">환율 리스트</a>
                                </li>
                                <li class="submenu-item ">
                                    <a href="${path }/admin/currency">충전 내역 관리</a>
                                </li>
                                <li class="submenu-item ">
                                    <a href="${path }/admin/currency">환불 내역 관리</a>
                                </li>
                            </ul>
                         </li>
                         
                         
                         <li class="sidebar-item  has-sub">
                            <a href="#" class='sidebar-link'>
                                <i class="bi bi-stack"></i>
                                <span>쇼핑 관리</span>
                            </a>
                            <ul class="submenu ">
                                <li class="submenu-item ">
                                    <a href="${path }/admin/currency">상품 관리</a>
                                </li>
                                <li class="submenu-item ">
                                    <a href="${path }/admin/currency">파트너사 관리</a>
                                </li>
                                <li class="submenu-item ">
                                    <a href="${path }/admin/currency">결제 내역 관리</a>
                                </li>
                            </ul>
                         </li>
                         
                         <li class="sidebar-item  has-sub">
                            <a href="#" class='sidebar-link'>
                                <i class="bi bi-stack"></i>
                                <span>회원 관리</span>
                            </a>
                            <ul class="submenu ">
                                <li class="submenu-item ">
                                    <a href="${path }/admin/currency">일반회원 관리</a>
                                </li>
                                <li class="submenu-item ">
                                    <a href="${path }/admin/currency">파트너 관리</a>
                                </li>
                                <li class="submenu-item ">
                                    <a href="${path }/admin/currency">관리자 관리</a>
                                </li>
                            </ul>
                         </li>
                        
                        

                        <li class="sidebar-item  has-sub">
                            <a href="#" class='sidebar-link'>
                                <i class="bi bi-stack"></i>
                                <span>Components</span>
                            </a>
                            <ul class="submenu ">
                                <li class="submenu-item ">
                                    <a href="https://zuramai.github.io/mazer/demo/component-alert.html">Alert</a>
                                </li>
                                <li class="submenu-item ">
                                    <a href="https://zuramai.github.io/mazer/demo/component-badge.html">Badge</a>
                                </li>
                                <li class="submenu-item ">
                                    <a href="https://zuramai.github.io/mazer/demo/component-breadcrumb.html">Breadcrumb</a>
                                </li>
                                <li class="submenu-item ">
                                    <a href="https://zuramai.github.io/mazer/demo/component-button.html">Button</a>
                                </li>
                                <li class="submenu-item ">
                                    <a href="https://zuramai.github.io/mazer/demo/component-card.html">Card</a>
                                </li>
                                <li class="submenu-item ">
                                    <a href="component-carousel.html">Carousel</a>
                                </li>
                                <li class="submenu-item ">
                                    <a href="https://zuramai.github.io/mazer/demo/component-dropdown.html">Dropdown</a>
                                </li>
                                <li class="submenu-item ">
                                    <a href="https://zuramai.github.io/mazer/demo/component-list-group.html">List Group</a>
                                </li>
                                <li class="submenu-item ">
                                    <a href="https://zuramai.github.io/mazer/demo/component-modal.html">Modal</a>
                                </li>
                                <li class="submenu-item ">
                                    <a href="https://zuramai.github.io/mazer/demo/component-navs.html">Navs</a>
                                </li>
                                <li class="submenu-item ">
                                    <a href="https://zuramai.github.io/mazer/demo/component-pagination.html">Pagination</a>
                                </li>
                                <li class="submenu-item ">
                                    <a href="https://zuramai.github.io/mazer/demo/component-progress.html">Progress</a>
                                </li>
                                <li class="submenu-item ">
                                    <a href="https://zuramai.github.io/mazer/demo/component-spinner.html">Spinner</a>
                                </li>
                                <li class="submenu-item ">
                                    <a href="https://zuramai.github.io/mazer/demo/component-tooltip.html">Tooltip</a>
                                </li>
                            </ul>
                        </li>

                        <li class="sidebar-item  has-sub">
                            <a href="#" class='sidebar-link'>
                                <i class="bi bi-collection-fill"></i>
                                <span>Extra Components</span>
                            </a>
                            <ul class="submenu ">
                                <li class="submenu-item ">
                                    <a href="https://zuramai.github.io/mazer/demo/extra-component-avatar.html">Avatar</a>
                                </li>
                                <li class="submenu-item ">
                                    <a href="https://zuramai.github.io/mazer/demo/extra-component-sweetalert.html">Sweet Alert</a>
                                </li>
                                <li class="submenu-item ">
                                    <a href="https://zuramai.github.io/mazer/demo/extra-component-toastify.html">Toastify</a>
                                </li>
                                <li class="submenu-item ">
                                    <a href="https://zuramai.github.io/mazer/demo/extra-component-rating.html">Rating</a>
                                </li>
                                <li class="submenu-item ">
                                    <a href="https://zuramai.github.io/mazer/demo/extra-component-divider.html">Divider</a>
                                </li>
                            </ul>
                        </li>

                        <li class="sidebar-item  has-sub">
                            <a href="#" class='sidebar-link'>
                                <i class="bi bi-grid-1x2-fill"></i>
                                <span>Layouts</span>
                            </a>
                            <ul class="submenu ">
                                <li class="submenu-item ">
                                    <a href="https://zuramai.github.io/mazer/demo/layout-default.html">Default Layout</a>
                                </li>
                                <li class="submenu-item ">
                                    <a href="https://zuramai.github.io/mazer/demo/layout-vertical-1-column.html">1 Column</a>
                                </li>
                                <li class="submenu-item ">
                                    <a href="https://zuramai.github.io/mazer/demo/layout-vertical-navbar.html">Vertical with Navbar</a>
                                </li>
                                <li class="submenu-item ">
                                    <a href="https://zuramai.github.io/mazer/demo/layout-horizontal.html">Horizontal Menu</a>
                                </li>
                            </ul>
                        </li>

                        <li class="sidebar-title">Forms &amp; Tables</li>

                        <li class="sidebar-item  has-sub">
                            <a href="#" class='sidebar-link'>
                                <i class="bi bi-hexagon-fill"></i>
                                <span>Form Elements</span>
                            </a>
                            <ul class="submenu ">
                                <li class="submenu-item ">
                                    <a href="https://zuramai.github.io/mazer/demo/form-element-input.html">Input</a>
                                </li>
                                <li class="submenu-item ">
                                    <a href="https://zuramai.github.io/mazer/demo/form-element-input-group.html">Input Group</a>
                                </li>
                                <li class="submenu-item ">
                                    <a href="https://zuramai.github.io/mazer/demo/form-element-select.html">Select</a>
                                </li>
                                <li class="submenu-item ">
                                    <a href="https://zuramai.github.io/mazer/demo/form-element-radio.html">Radio</a>
                                </li>
                                <li class="submenu-item ">
                                    <a href="https://zuramai.github.io/mazer/demo/form-element-checkbox.html">Checkbox</a>
                                </li>
                                <li class="submenu-item ">
                                    <a href="https://zuramai.github.io/mazer/demo/form-element-textarea.html">Textarea</a>
                                </li>
                            </ul>
                        </li>

                        <li class="sidebar-item  ">
                            <a href="form-layout.html" class='sidebar-link'>
                                <i class="bi bi-file-earmark-medical-fill"></i>
                                <span>Form Layout</span>
                            </a>
                        </li>

                        <li class="sidebar-item  has-sub">
                            <a href="#" class='sidebar-link'>
                                <i class="bi bi-pen-fill"></i>
                                <span>Form Editor</span>
                            </a>
                            <ul class="submenu ">
                                <li class="submenu-item ">
                                    <a href="https://zuramai.github.io/mazer/demo/form-editor-quill.html">Quill</a>
                                </li>
                                <li class="submenu-item ">
                                    <a href="https://zuramai.github.io/mazer/demo/form-editor-ckeditor.html">CKEditor</a>
                                </li>
                                <li class="submenu-item ">
                                    <a href="https://zuramai.github.io/mazer/demo/form-editor-summernote.html">Summernote</a>
                                </li>
                                <li class="submenu-item ">
                                    <a href="https://zuramai.github.io/mazer/demo/form-editor-tinymce.html">TinyMCE</a>
                                </li>
                            </ul>
                        </li>

                        <li class="sidebar-item  ">
                            <a href="table.html" class='sidebar-link'>
                                <i class="bi bi-grid-1x2-fill"></i>
                                <span>Table</span>
                            </a>
                        </li>

                        <li class="sidebar-item  ">
                            <a href="table-datatable.html" class='sidebar-link'>
                                <i class="bi bi-file-earmark-spreadsheet-fill"></i>
                                <span>Datatable</span>
                            </a>
                        </li>

                        <li class="sidebar-title">Extra UI</li>

                        <li class="sidebar-item  has-sub">
                            <a href="#" class='sidebar-link'>
                                <i class="bi bi-pentagon-fill"></i>
                                <span>Widgets</span>
                            </a>
                            <ul class="submenu ">
                                <li class="submenu-item ">
                                    <a href="https://zuramai.github.io/mazer/demo/ui-widgets-chatbox.html">Chatbox</a>
                                </li>
                                <li class="submenu-item ">
                                    <a href="https://zuramai.github.io/mazer/demo/ui-widgets-pricing.html">Pricing</a>
                                </li>
                                <li class="submenu-item ">
                                    <a href="https://zuramai.github.io/mazer/demo/ui-widgets-todolist.html">To-do List</a>
                                </li>
                            </ul>
                        </li>

                        <li class="sidebar-item  has-sub">
                            <a href="#" class='sidebar-link'>
                                <i class="bi bi-egg-fill"></i>
                                <span>Icons</span>
                            </a>
                            <ul class="submenu ">
                                <li class="submenu-item ">
                                    <a href="https://zuramai.github.io/mazer/demo/ui-icons-bootstrap-icons.html">Bootstrap Icons </a>
                                </li>
                                <li class="submenu-item ">
                                    <a href="https://zuramai.github.io/mazer/demo/ui-icons-fontawesome.html">Fontawesome</a>
                                </li>
                                <li class="submenu-item ">
                                    <a href="https://zuramai.github.io/mazer/demo/ui-icons-dripicons.html">Dripicons</a>
                                </li>
                            </ul>
                        </li>

                        <li class="sidebar-item  has-sub">
                            <a href="#" class='sidebar-link'>
                                <i class="bi bi-bar-chart-fill"></i>
                                <span>Charts</span>
                            </a>
                            <ul class="submenu ">
                                <li class="submenu-item ">
                                    <a href="https://zuramai.github.io/mazer/demo/ui-chart-chartjs.html">ChartJS</a>
                                </li>
                                <li class="submenu-item ">
                                    <a href="https://zuramai.github.io/mazer/demo/ui-chart-apexcharts.html">Apexcharts</a>
                                </li>
                            </ul>
                        </li>

                        <li class="sidebar-item  ">
                            <a href="ui-file-uploader.html" class='sidebar-link'>
                                <i class="bi bi-cloud-arrow-up-fill"></i>
                                <span>File Uploader</span>
                            </a>
                        </li>

                        <li class="sidebar-item  has-sub">
                            <a href="#" class='sidebar-link'>
                                <i class="bi bi-map-fill"></i>
                                <span>Maps</span>
                            </a>
                            <ul class="submenu ">
                                <li class="submenu-item ">
                                    <a href="https://zuramai.github.io/mazer/demo/ui-map-google-map.html">Google Map</a>
                                </li>
                                <li class="submenu-item ">
                                    <a href="https://zuramai.github.io/mazer/demo/ui-map-jsvectormap.html">JS Vector Map</a>
                                </li>
                            </ul>
                        </li>

                        <li class="sidebar-title">Pages</li>

                        <li class="sidebar-item  ">
                            <a href="https://zuramai.github.io/mazer/demo/application-email.html" class='sidebar-link'>
                                <i class="bi bi-envelope-fill"></i>
                                <span>Email Application</span>
                            </a>
                        </li>

                        <li class="sidebar-item  ">
                            <a href="https://zuramai.github.io/mazer/demo/application-chat.html" class='sidebar-link'>
                                <i class="bi bi-chat-dots-fill"></i>
                                <span>Chat Application</span>
                            </a>
                        </li>

                        <li class="sidebar-item  ">
                            <a href="https://zuramai.github.io/mazer/demo/application-gallery.html" class='sidebar-link'>
                                <i class="bi bi-image-fill"></i>
                                <span>Photo Gallery</span>
                            </a>
                        </li>

                        <li class="sidebar-item  ">
                            <a href="https://zuramai.github.io/mazer/demo/application-checkout.html" class='sidebar-link'>
                                <i class="bi bi-basket-fill"></i>
                                <span>Checkout Page</span>
                            </a>
                        </li>

                        <li class="sidebar-item  has-sub">
                            <a href="#" class='sidebar-link'>
                                <i class="bi bi-person-badge-fill"></i>
                                <span>Authentication</span>
                            </a>
                            <ul class="submenu ">
                                <li class="submenu-item ">
                                    <a href="https://zuramai.github.io/mazer/demo/auth-login.html">Login</a>
                                </li>
                                <li class="submenu-item ">
                                    <a href="https://zuramai.github.io/mazer/demo/auth-register.html">Register</a>
                                </li>
                                <li class="submenu-item ">
                                    <a href="https://zuramai.github.io/mazer/demo/auth-forgot-password.html">Forgot Password</a>
                                </li>
                            </ul>
                        </li>

                        <li class="sidebar-item  has-sub">
                            <a href="#" class='sidebar-link'>
                                <i class="bi bi-x-octagon-fill"></i>
                                <span>Errors</span>
                            </a>
                            <ul class="submenu ">
                                <li class="submenu-item ">
                                    <a href="https://zuramai.github.io/mazer/demo/error-403.html">403</a>
                                </li>
                                <li class="submenu-item ">
                                    <a href="https://zuramai.github.io/mazer/demo/error-404.html">404</a>
                                </li>
                                <li class="submenu-item ">
                                    <a href="https://zuramai.github.io/mazer/demo/error-500.html">500</a>
                                </li>
                            </ul>
                        </li>

                        <li class="sidebar-title">Raise Support</li>

                        <li class="sidebar-item  ">
                            <a href="https://zuramai.github.io/mazer/docs" class='sidebar-link'>
                                <i class="bi bi-life-preserver"></i>
                                <span>Documentation</span>
                            </a>
                        </li>

                        <li class="sidebar-item  ">
                            <a href="https://github.com/zuramai/mazer/blob/main/CONTRIBUTING.md" class='sidebar-link'>
                                <i class="bi bi-puzzle"></i>
                                <span>Contribute</span>
                            </a>
                        </li>

                        <li class="sidebar-item  ">
                            <a href="https://github.com/zuramai/mazer#donate" class='sidebar-link'>
                                <i class="bi bi-cash"></i>
                                <span>Donate</span>
                            </a>
                        </li>

                    </ul>
                </div>
                <button class="sidebar-toggler btn x"><i data-feather="x"></i></button>
            </div>
        </div>