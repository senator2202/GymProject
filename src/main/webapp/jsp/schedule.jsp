<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.user.account.locale.postfix}"
               scope="session"/>
<fmt:setBundle basename="property/pagecontent"/>

<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="PONIGYM Template">
    <meta name="keywords" content="PONIGYM, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>PONIGYM | Template</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:400,500,700&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Oswald:300,400,500,600,700&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="/assets/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="/assets/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="/assets/css/themify-icons.css" type="text/css">
    <link rel="stylesheet" href="/assets/css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="/assets/css/magnific-popup.css" type="text/css">
    <link rel="stylesheet" href="/assets/css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="/assets/css/style.css" type="text/css">
    <link rel="stylesheet" href="/assets/css/popup.css"/>
</head>

<body>
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>

    <jsp:include page="/jsp/part/header_black.jsp"/>

    <!-- PopUp Buy Start -->
        <a href="#x" class="overlay" id="popupBuy"></a>
        <div class="popup">
            <div class="text-center">
                    <div id="carousel" class="carousel slide" data-ride="carousel" data-interval="false">
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <img class="card-img-top mb-3 w-auto" src="/assets/img/five.png"  alt="Buy" >
                                <p/>
                                <a href="/mainController?command=buy_trainings&number=5">
                                    <button class="primary-btn">
                                        <fmt:message key="buy_trainings.buyFor"/> ${(100 - user.personalDiscount)/100*5*20} <fmt:message key="buy_trainings.br"/>
                                    </button>
                                </a>
                            </div>
                            <div class="carousel-item">
                                <img class="card-img-top mb-3 w-auto" src="/assets/img/ten.png"  alt="Buy" >
                                <p/>
                                <a href="/mainController?command=buy_trainings&number=10">
                                    <button class="primary-btn">
                                        <fmt:message key="buy_trainings.buyFor"/> ${(100 - user.personalDiscount)/100*10*20} <fmt:message key="buy_trainings.br"/>
                                    </button>
                                </a>
                            </div>
                            <div class="carousel-item">
                                <img class="card-img-top mb-3 w-auto" src="/assets/img/twenty.png"  alt="Buy" >
                                <p/>
                                <a href="/mainController?command=buy_trainings&number=20">
                                    <button class="primary-btn">
                                        <fmt:message key="buy_trainings.buyFor"/> ${(100 - user.personalDiscount)/100*20*20} <fmt:message key="buy_trainings.br"/>
                                    </button>
                                </a>
                            </div>
                        </div>
                        <!-- Navigation -->
                        <a class="carousel-control-prev bg-dark" href="#carousel" role="button" data-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="sr-only"><fmt:message key="buy_trainings.next"/></span>
                        </a>
                        <a class="carousel-control-next bg-dark" href="#carousel" role="button" data-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="sr-only"><fmt:message key="buy_trainings.previous"/></span>
                        </a>
                    </div>
            </div>
            <a class="close" title=<fmt:message key="trainer_popup.close"/> href="#close"></a>
        </div>
    <!-- PopUp Buy Start -->

    <!-- Trainer Table Schedule Section Begin -->
    <section class="trainer-schedule class-timetable spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="section-title">
                        <a href="#popupBuy" style="alignment: center;">
                            <button class="primary-btn">
                                <fmt:message key="schedule.buyTrainings"/>
                            </button>
                        </a>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-12">
                    <div class="site-text">
                        <fmt:message key="schedule.yourBalance"/> ${user.moneyBalance} <fmt:message key="schedule.br"/>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-12">
                    <div class="site-text">
                        <fmt:message key="schedule.youHave"/> ${user.boughtTrainings} <fmt:message key="schedule.boughtTrainings"/>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="part/calendar.jsp"/>
    </section>



    <!-- Footer Section Begin -->
    <footer class="footer-section">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-6">
                    <div class="map-location">
                        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d33245.297803635964!2d-73.76987401620775!3d40.704774398815005!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x89c24fa5d33f083b%3A0xc80b8f06e177fe62!2sNew%20York%2C%20NY%2C%20USA!5e0!3m2!1sen!2sbd!4v1575866843291!5m2!1sen!2sbd" style="border:0;" allowfullscreen=""></iframe>
                        <div class="map-widget">
                            <i class="fa fa-map-marker"></i>
                            <div class="map-address">
                                <img src="../assets/img/map-location.jpg" alt="">
                                <ul class="map-text">
                                    <li><span>Address:</span> Iris Watson, Box 283, NY</li>
                                    <li><span>Phone:</span> 12-456-791</li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="footer-form set-bg" data-setbg="../assets/img/contact-form-bg.jpg">
                        <div class="row">
                            <div class="col-lg-8">
                                <div class="section-title">
                                    <h2>Request A Call Back</h2>
                                    <p>Shape your body and burn fat with strength training. With the right equipment
                                        such as free weights or resistance machines.</p>
                                </div>
                                <form action="#">
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <input type="text" placeholder="Name">
                                        </div>
                                        <div class="col-lg-6">
                                            <input type="text" placeholder="Email">
                                        </div>
                                        <div class="col-lg-12">
                                            <input type="text" placeholder="Subject">
                                            <textarea placeholder="Message"></textarea>
                                            <button type="submit">Submit <i class="ti-angle-double-right"></i></button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="register normal-register">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="copyright">
                            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                        </div>
                        <div class="footer-widget">
                            <ul>
                                <li class="active">Privacy Policy</li>
                                <li>Terms Of Service</li>
                                <li>Careers</li>
                            </ul>
                        </div>
                        <div class="footer-links">
                            <a href="#"><i class="fa fa-facebook"></i></a>
                            <a href="#"><i class="fa fa-twitter"></i></a>
                            <a href="#"><i class="fa fa-instagram"></i></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!-- Footer Section End -->

    <!-- Search model Begin -->
    <div class="search-model">
        <div class="h-100 d-flex align-items-center justify-content-center">
            <div class="search-close-switch">+</div>
            <form class="search-model-form">
                <input type="text" id="search-input" placeholder="Search here.....">
            </form>
        </div>
    </div>
    <!-- Search model end -->

    <!-- Js Plugins -->
    <script src="../assets/js/jquery-3.3.1.min.js"></script>
    <script src="../assets/js/bootstrap.min.js"></script>
    <script src="../assets/js/jquery.magnific-popup.min.js"></script>
    <script src="../assets/js/mixitup.min.js"></script>
    <script src="../assets/js/jquery.slicknav.js"></script>
    <script src="../assets/js/owl.carousel.min.js"></script>
    <script src="../assets/js/main.js"></script>
</body>

</html>