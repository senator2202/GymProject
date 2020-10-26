<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setBundle basename="property/pagecontent"/>

<script src="/assets/js/login.js"></script>

<div class="modal fade" id="modalLogin" role="dialog">
	<div class="modal-dialog modal-dialog-centered">
		<div class="modal-content">
			<div class="modal-body">
				<div class="login-wrap">
					<div class="login-html">
						<input id="tab-1" type="radio" name="tab" class="sign-in" checked>
						<label for="tab-1" class="tab">
							<fmt:message key="login.signIn"/>
						</label>
						<input id="tab-2" type="radio" name="tab" class="sign-up">
						<label for="tab-2" class="tab">
							<fmt:message key="login.signUp"/>
						</label>
						<div class="login-form">
							<form action="/mainController" method="post" class="needs-validation" novalidate>
								<div class="sign-in-htm">
									<input type="hidden" name="command" value="login"/>
									<div class="group">
										<label for="login" class="label"><fmt:message key="login.userName"/></label>
										<input class="input" type="text" id="login" name="login"
										       value="${login}" required pattern="[a-zA-Z][a-zA-Z0-9_]{1,19}">
										<div class="invalid-feedback">
											<fmt:message key="login.invalidLoginFormat"/>
										</div>
									</div>
									<div class="group">
										<label for="loginPassword" class="label"><fmt:message
												key="login.password"/></label>
										<input class="input" id="loginPassword" type="password" name="loginPassword"
										       value="${password}" required pattern="[a-zA-Z0-9_]{5,30}">
										<div class="invalid-feedback">
											<fmt:message key="login.invalidPasswordFormat"/>
										</div>
									</div>
									<div class="group">
										<fmt:message key="login.signIn" var="loginSubmit" scope="page"/>
										<input type="submit" class="button" value="${loginSubmit}" id="submitLogin">
									</div>

									<c:if test="${incorrectLoginPassword==true}">
										<label style="color: red; font-size: medium"><fmt:message
												key="login.incorrectLoginPassword"/></label>
									</c:if>
									<label style="color: red; font-size: medium; display: none" id="needLogin">
										You need login first!
									</label>
									<div class="hr"></div>
								</div>
							</form>
							<form action="/mainController" method="post" class="needs-validation" novalidate
							      id="regForm">
								<div class="sign-up-htm">
									<input type="hidden" name="command" value="register"/>
									<div class="group">
										<label for="regLogin" class="label">
											<fmt:message key="login.userName"/>
										</label>
										<input id="regLogin" type="text" name="regLogin" class="input"
										       value="${regLogin}" required pattern="[a-zA-Z][a-zA-Z0-9_]{1,19}">
										<div class="invalid-feedback">
											<fmt:message key="login.invalidLoginFormat"/>
										</div>
									</div>
									<div class="group">
										<label for="regPassword" class="label"><fmt:message
												key="login.password"/></label>
										<input id="regPassword" type="password" name="regPassword" class="input"
										       value="${regPassword}" required pattern="[a-zA-Z0-9_]{5,30}">
										<div class="invalid-feedback">
											<fmt:message key="login.invalidPasswordFormat"/>
										</div>
									</div>
									<div class="group">
										<label for="repeatPassword" class="label"><fmt:message
												key="login.repeatPassword"/></label>
										<input id="repeatPassword" name="repeatPassword" type="password" class="input"
										       required oninput="checkSimilarPasswords()">
										<div class="invalid-feedback">
											<fmt:message key="login.passwordsNotEqual"/>
										</div>
									</div>
									<div class="group">
										<label for="regEmail" class="label"><fmt:message key="login.email"/></label>
										<input id="regEmail" type="email" name="regEmail" class="input" required
										       value="${regEmail}">
										<div class="invalid-feedback">
											<fmt:message key="login.invalidEmailFormat"/>
										</div>
									</div>
									<div class="group">
										<fmt:message key="login.signUp" var="regSubmit" scope="page"/>
										<input type="submit" class="button" value="${regSubmit}"
										       onclick="checkSimilarPasswords()">
									</div>
									<div class="hr"></div>
									<c:if test="${loginEmailExists==true}">
										<label style="color: red; font-size: medium"><fmt:message
												key="login.loginEmailExists"/></label>
									</c:if>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
