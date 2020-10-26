<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.user.account.locale.postfix}"
               scope="session"/>
<fmt:setBundle basename="property/pagecontent"/>

<div class="modal fade" id="modalAccessError" role="dialog">
	<div class="modal-dialog modal-dialog-centered">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title w-100 text-center">
					<label class="label" style="font-size: large"><fmt:message
							key="access_error.message"/></label></label>
				</h5>
			</div>
		</div>
	</div>
</div>