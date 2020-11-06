<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="${sessionScope.user.account.locale.postfix}"
               scope="session"/>
<fmt:setBundle basename="property/pagecontent"/>

<div class="modal fade" id="modalConfirmed" role="dialog">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title w-100 text-center" style="font-size: large; color: black">
                    ${confirmedAccount}: <fmt:message key="confirmed.message"/>
                </h5>
            </div>
        </div>
    </div>
</div>