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
</head>

<body>
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>

    <jsp:include page="/jsp/part/header_black.jsp"/>

    <!-- Map Section Begin -->
    <div class="contact-map">
        <iframe src="https://maps.google.com/maps?q=minsk%20adrenalin%20loshitsa&t=&z=13&ie=UTF8&iwloc=&output=embed" style="border:0;" allowfullscreen=""></iframe>
    </div>
    <!-- Map Section End -->

    <!-- Contact Section Begin -->
    <section class="contact-section spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-4">
                    <div class="contact-info">
                        <i class="ti-location-pin"></i>
                        <p>Iris Watson. 10, P.O. Box 283 Newyork</p>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="contact-info">
                        <i class="ti-email"></i>
                        <ul>
                            <li><span>Phone:</span> 12-456-791</li>
                            <li><span>Mail:</span> colorlib@gmail.com</li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="contact-info">
                        <i class="ti-timer"></i>
                        <ul>
                            <li><span>Week Days:</span> 10:00 – 22:00</li>
                            <li><span>Sunday:</span> Close</li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="contact-form">
                <div class="section-title">
                    <h2>Leave message</h2>
                    <p>Our staff will call back later and answer your questions.</p>
                </div>
                <form action="/mainController" method="post">
                    <input type="hidden" name="command" value="add_feedback"/>
                    <div class="row">
                        <div class="col-lg-6">
                            <input type="text" placeholder="Name" name="senderName" id="senderName">
                        </div>
                        <div class="col-lg-6">
                            <input type="email" placeholder="Email" name="senderEmail" id="senderEmail" required>
                        </div>
                        <div class="col-lg-12">
                            <input type="text" name="feedbackSubject"
                                   placeholder="Subject" id="feedbackSubject">
                            <textarea name="feedbackMessage" id="feedbackMessage" required
                                      placeholder="Message"></textarea>
                            <button type="submit">Submit <i
                                    class="ti-angle-double-right"></i>
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </section>
    <!-- Contact Section End -->

    <!-- Js Plugins -->
    <script src="/assets/js/jquery-3.3.1.min.js"></script>
    <script src="/assets/js/bootstrap.min.js"></script>
    <script src="/assets/js/jquery.magnific-popup.min.js"></script>
    <script src="/assets/js/mixitup.min.js"></script>
    <script src="/assets/js/jquery.slicknav.js"></script>
    <script src="/assets/js/owl.carousel.min.js"></script>
    <script src="/assets/js/main.js"></script>
</body>

</html>