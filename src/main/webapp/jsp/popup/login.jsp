<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setBundle basename="property/pagecontent"/>


<a href="#x" class="overlay" id="popupLogin"></a>
<div class="popup ">
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
					<form action="/mainController" method="post">
						<div class="sign-in-htm">
							<input type="hidden" name="command" value="login"/>
							<div class="group">
								<label for="login"><fmt:message key="login.userName"/></label>
								<input class="input" type="text" id="login" name="login" value="${loginValid}">
							</div>
							<div class="group">
								<label for="login_password" class="label"><fmt:message key="login.password"/></label>
								<input class="input" id="login_password" type="password" name="password" value="${passwordValid}" required>
							</div>

							<%--<div class="group">
								<input id="check" type="checkbox" class="check" checked>
								<label for="check"><span class="icon"></span>
									<fmt:message key="login.keepSigned" />
								</label>
							</div>--%>
							<div class="group">
								<fmt:message key="login.signIn" var="login_submit" scope="page"/>
								<input type="submit" class="button" value="${login_submit}">
							</div>
							<div class="hr"></div>
							<div class="foot-lnk">
								<a href="#forgot">
									<fmt:message key="login.forgotPassword"/>
								</a>
							</div>
						</div>
					</form>

					<form action="/mainController" method="post">
						<div class="sign-up-htm">
							<input type="hidden" name="command" value="register"/>
							<div class="group">
								<label for="reg_user" class="label">
									<fmt:message key="login.userName"/>
								</label>
								<input id="reg_user" type="text" name="login" class="input" required pattern="[a-zA-Z][a-zA-Z0-9_]{1,19}">
							</div>
							<div class="group">
								<label for="reg_password" class="label"><fmt:message key="login.password"/></label>
								<input id="reg_password" type="password" name="password" class="input" required pattern="[a-zA-Z0-9_]{5,30}">
							</div>
							<div class="group">
								<label for="repeat_password" class="label"><fmt:message key="login.repeatPassword"/></label>
								<input id="repeat_password" type="password" class="input" required oninput="this.value != document.getElementById('reg_password').value ? this.setCustomValidity('Passwords are not the same!') : this.setCustomValidity('')">
							</div>
							<div class="group">
								<label for="email" class="label"><fmt:message key="login.email"/></label>
								<input id="email" type="email" name="email" class="input"  required>
							</div>
							<div class="group">
								<fmt:message key="login.signUp" var="reg_submit" scope="page" />
								<input type="submit" class="button" value="${reg_submit}">
							</div>
							<div class="hr"></div>
							<div class="foot-lnk">
								<label for="tab-1"><fmt:message key="login.alreadyRegistered"/></label>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	<a class="close" title=<fmt:message key="trainer_popup.close"/> href="#close"></a>
</div>