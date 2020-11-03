<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="${sessionScope.user.account.locale.postfix}"
               scope="session"/>
<fmt:setBundle basename="property/pagecontent"/>

<div class="modal fade" id="modalAllTrainers" role="dialog">
	<div class="modal-dialog modal-dialog-centered">
		<div class="modal-content">
			<div class="modal-body">
				<div class="card" style="margin-top: 0px; margin-bottom: 0px;">
					<div class="card-body">
						<div class="text-center">
							<div id="carousel" class="carousel slide" data-ride="carousel" data-interval="false">
								<div class="carousel-inner">
									<div class="carousel-item active">
										<h>${trainers.get(0).firstName} ${trainers.get(0).lastName}</h>
										<img class="card-img-top mb-3 w-auto" src="${trainers.get(0).imageName}">
									</div>
									<c:forEach items="${trainers}" var="trainer" begin="1">
											<div class="carousel-item">
												<h>${trainer.firstName} ${trainer.lastName}</h>
												<img class="card-img-top mb-3 w-auto" src="${trainer.imageName}">
											</div>
									</c:forEach>
								</div>
								<!-- Navigation -->
								<a class="carousel-control-prev bg-dark" href="#carousel" role="button"
								   data-slide="prev">
									<span class="carousel-control-prev-icon" aria-hidden="true"></span>
									<span class="sr-only"><fmt:message key="buy_trainings.next"/></span>
								</a>
								<a class="carousel-control-next bg-dark" href="#carousel" role="button"
								   data-slide="next">
									<span class="carousel-control-next-icon" aria-hidden="true"></span>
									<span class="sr-only"><fmt:message key="buy_trainings.previous"/></span>
								</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>