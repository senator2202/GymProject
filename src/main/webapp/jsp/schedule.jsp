<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
    <link rel="stylesheet" href="../assets/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="../assets/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="../assets/css/themify-icons.css" type="text/css">
    <link rel="stylesheet" href="../assets/css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="../assets/css/magnific-popup.css" type="text/css">
    <link rel="stylesheet" href="../assets/css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="../assets/css/style.css" type="text/css">
    <link rel="stylesheet" href="/assets/css/popup.css"/>
</head>

<body>
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>

    <jsp:include page="/jsp/part/header_black.jsp"/>

    <!-- PopUp Buy Start -->
    <form>
        <a href="#x" class="overlay" id="win1"></a>
        <div class="popup">
            <div class="text-center">
                    <div id="carousel" class="carousel slide" data-ride="carousel" data-interval="false">
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <a href="/mainController?command=buy_trainings">
                                    <img class="card-img-top mb-3 w-auto" src="/assets/img/five.png"  alt="Buy" >
                                </a>
                            </div>
                            <div class="carousel-item">
                                <a href="/mainController?command=buy_trainings">
                                    <img class="card-img-top mb-3 w-auto" src="/assets/img/ten.png"  alt="Buy" >
                                </a>
                            </div>
                            <div class="carousel-item">
                                <a href="/mainController?command=buy_trainings">
                                    <img class="card-img-top mb-3 w-auto" src="/assets/img/twenty.png"  alt="Buy" >
                                </a>
                            </div>
                        </div>
                        <!-- Navigation -->
                        <a class="carousel-control-prev bg-dark" href="#carousel" role="button" data-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="sr-only">Предыдущий</span>
                        </a>
                        <a class="carousel-control-next bg-dark" href="#carousel" role="button" data-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="sr-only">Следующий</span>
                        </a>
                    </div>
            </div>
        </div>
    </form>
    <!-- PopUp Buy Start -->

    <!-- Trainer Table Schedule Section Begin -->
    <section class="trainer-schedule class-timetable spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="section-title">
                        <a href="#win1"style="alignment: center;">
                            <button class="primary-btn">
                                Buy Trainings
                            </button>
                        </a>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-12">
                    <div class="site-text">
                        You have 0 bought trainings!
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-12">
                    <div class="section-title">
                        <h2>

                        </h2>
                        <div class="nav-controls">
                            <ul class="schedule-filter">
                                <li class="active" data-tsfilter="all">All Class</li>
                                <li data-tsfilter="gym">Gym</li>
                                <li data-tsfilter="crossfit">Crossfit</li>
                                <li data-tsfilter="cardio">Cardio</li>
                                <li data-tsfilter="body">Body</li>
                                <li data-tsfilter="yoga">Yoga</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="schedule-table">
                        <table>
                            <thead>
                                <tr>
                                    <th></th>
                                    <th>Monday</th>
                                    <th>Tuesday</th>
                                    <th>Wednesday</th>
                                    <th>Thursday</th>
                                    <th>Friday</th>
                                    <th>Saturday</th>
                                    <th>Sunday</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td class="workout-time">10.00</td>
                                    <td class="gym ts-item" data-tsmeta="gym">
                                        <h6>Gym</h6>
                                        <span>10.00 - 11.00</span>
                                        <div class="trainer-name">
                                            John Smith
                                        </div>
                                    </td>
                                    <td></td>
                                    <td class="yoga ts-item" data-tsmeta="yoga">
                                        <h6>Yoga</h6>
                                        <span>10.00 - 12.00</span>
                                        <div class="trainer-name">
                                            John Smith
                                        </div>
                                    </td>
                                    <td></td>
                                    <td class="body ts-item" data-tsmeta="body">
                                        <h6>Body</h6>
                                        <span>10.00 - 12.00</span>
                                        <div class="trainer-name">
                                            John Smith
                                        </div>
                                    </td>
                                    <td></td>
                                    <td class="cardio ts-item" data-tsmeta="cardio">
                                        <h6>Cardio</h6>
                                        <span>10.00 - 11.00</span>
                                        <div class="trainer-name">
                                            John Smith
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="workout-time">14.00</td>
                                    <td></td>
                                    <td class="running ts-item" data-tsmeta="running">
                                        <h6>Running</h6>
                                        <span>14.00 - 16.00</span>
                                        <div class="trainer-name">
                                            John Smith
                                        </div>
                                    </td>
                                    <td></td>
                                    <td class="box ts-item" data-tsmeta="box">
                                        <h6>Box</h6>
                                        <span>14.00 - 15.00</span>
                                        <div class="trainer-name">
                                            John Smith
                                        </div>
                                    </td>
                                    <td></td>
                                    <td class="gym ts-item" data-tsmeta="gym">
                                        <h6>Gym</h6>
                                        <span>14.00 - 16.00</span>
                                        <div class="trainer-name">
                                            John Smith
                                        </div>
                                    </td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td class="workout-time">16.00</td>
                                    <td class="cardio ts-item" data-tsmeta="cardio">
                                        <h6>Cardio</h6>
                                        <span>16.00 - 18.00</span>
                                        <div class="trainer-name">
                                            John Smith
                                        </div>
                                    </td>
                                    <td></td>
                                    <td class="gym ts-item" data-tsmeta="gym">
                                        <h6>Gym</h6>
                                        <span>16.00 - 19.00</span>
                                        <div class="trainer-name">
                                            John Smith
                                        </div>
                                    </td>
                                    <td></td>
                                    <td class="yoga ts-item" data-tsmeta="yoga">
                                        <h6>Yoga</h6>
                                        <span>16.00 - 18.00</span>
                                        <div class="trainer-name">
                                            John Smith
                                        </div>
                                    </td>
                                    <td></td>
                                    <td class="gym ts-item" data-tsmeta="gym">
                                        <h6>Gym</h6>
                                        <span>16.00 - 20.00</span>
                                        <div class="trainer-name">
                                            John Smith
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="workout-time">18.00</td>
                                    <td class="box ts-item" data-tsmeta="box">
                                        <h6>Box</h6>
                                        <span>18.00 - 22.00</span>
                                        <div class="trainer-name">
                                            John Smith
                                        </div>
                                    </td>
                                    <td class="body ts-item" data-tsmeta="body">
                                        <h6>Body</h6>
                                        <span>18.00 - 20.00</span>
                                        <div class="trainer-name">
                                            John Smith
                                        </div>
                                    </td>
                                    <td></td>
                                    <td class="crossfit ts-item" data-tsmeta="crossfit">
                                        <h6>Crossfit</h6>
                                        <span>18.00 - 21.00</span>
                                        <div class="trainer-name">
                                            John Smith
                                        </div>
                                    </td>
                                    <td></td>
                                    <td class="cardio ts-item" data-tsmeta="cardio">
                                        <h6>Cardio</h6>
                                        <span>18.00 - 22.00</span>
                                        <div class="trainer-name">
                                            John Smith
                                        </div>
                                    </td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td class="workout-time">20.00</td>
                                    <td></td>
                                    <td class="gym ts-item" data-tsmeta="">
                                        <h6>Gym</h6>
                                        <span>20.00 - 12.00</span>
                                        <div class="trainer-name">
                                            John Smith
                                        </div>
                                    </td>
                                    <td class="body ts-item" data-tsmeta="">
                                        <h6>Body</h6>
                                        <span>20.00 - 21.00</span>
                                        <div class="trainer-name">
                                            John Smith
                                        </div>
                                    </td>
                                    <td></td>
                                    <td class="cardio ts-item" data-tsmeta="">
                                        <h6>Cardio</h6>
                                        <span>20.00 - 22.00</span>
                                        <div class="trainer-name">
                                            John Smith
                                        </div>
                                    </td>
                                    <td></td>
                                    <td class="crossfit ts-item" data-tsmeta="">
                                        <h6>Crossfit</h6>
                                        <span>20.00 - 21.00</span>
                                        <div class="trainer-name">
                                            John Smith
                                        </div>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Trainer Table Schedule Section End -->

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