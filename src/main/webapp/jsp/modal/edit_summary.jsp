<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="${sessionScope.user.account.locale.postfix}"
               scope="session"/>
<fmt:setBundle basename="property/pagecontent"/>

<div class="modal fade" id="modalEditSummary" role="dialog">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title w-100 text-center">
                    <fmt:message key="edit_description.title"/>
                </h5>
            </div>
            <div class="modal-body">
                <div class="card" style="margin-top: 0px; margin-bottom: 0px;">
                    <div class="card-body">
                        <form action="/mainController" method="post">
                            <input type="hidden" name="command" value="update_short_summary"/>
                            <div class="form-group">
								<textarea class="form-control" rows="6" id="shortSummary" maxlength="250"
                                          name="shortSummary">
                                    ${user.shortSummary}
                                </textarea>
                            </div>
                            <button type="submit" class="btn btn-primary mb-2"><fmt:message
                                    key="edit_description.save"/></button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>