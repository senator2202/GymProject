$('#modalClientProfile').on('show.bs.modal', function (e) {
    var firstName = e.relatedTarget.dataset.firstname;
    var lastName = e.relatedTarget.dataset.lastname;
    var imageName = e.relatedTarget.dataset.imagename;
    var phone = e.relatedTarget.dataset.phone;
    var role = e.relatedTarget.dataset.role;
    var email = e.relatedTarget.dataset.email;
    var modal = $(this);
    modal.find('#roleInput').text(role);
    modal.find('#imagePreview').css("background-image", "url('" + imageName + "')");
    modal.find('#nameText').text(firstName + ' ' + lastName);
    modal.find('#emailText').text(email);
    modal.find('#phoneText').text(phone);
    modal.find('#roleText').text(role);
    var moneyBalance = e.relatedTarget.dataset.moneybalance;
    var personalDiscount = e.relatedTarget.dataset.personaldiscount;
    var boughtTrainings = e.relatedTarget.dataset.boughttrainings;
    modal.find('#moneyText').text(moneyBalance);
    modal.find('#discountText').text(personalDiscount);
    modal.find('#boughtText').text(boughtTrainings);
});

$('#modalTrainerProfile').on('show.bs.modal', function (e) {
    var firstName = e.relatedTarget.dataset.firstname;
    var lastName = e.relatedTarget.dataset.lastname;
    var imageName = e.relatedTarget.dataset.imagename;
    var phone = e.relatedTarget.dataset.phone;
    var role = e.relatedTarget.dataset.role;
    var email = e.relatedTarget.dataset.email;
    var modal = $(this);
    modal.find('#roleInput').text(role);
    modal.find('#imagePreview').css("background-image", "url('" + imageName + "')");
    modal.find('#nameText').text(firstName + ' ' + lastName);
    modal.find('#emailText').text(email);
    modal.find('#phoneText').text(phone);
    modal.find('#roleText').text(role);
    var institution = e.relatedTarget.dataset.institution;
    var graduationYear = e.relatedTarget.dataset.graduationyear;
    var instagramLink = e.relatedTarget.dataset.instagramlink;
    var rating = e.relatedTarget.dataset.rating;
    modal.find('#institutionText').text(institution);
    modal.find('#graduationText').text(graduationYear);
    modal.find('#instagramText').text(instagramLink);
    modal.find('#ratingText').text(rating);
});

$('#modalFeedbackReply').on('show.bs.modal', function (e) {
    var replyEmail = e.relatedTarget.dataset.replyemail;
    var replySubject = e.relatedTarget.dataset.replysubject;
    var feedbackId = e.relatedTarget.dataset.feedbackid;
    var modal = $(this);
    modal.find('#feedbackId').val(feedbackId);
    modal.find('#replyEmail').val(replyEmail);
    modal.find('#replySubject').val(replySubject);
});

$('#modalEditTraining').on('show.bs.modal', function (e) {
    var trainingId = e.relatedTarget.dataset.trainingid;
    var trainerName = e.relatedTarget.dataset.trainername;
    var trainingDate = e.relatedTarget.dataset.trainingdate;
    var trainingTime = e.relatedTarget.dataset.trainingtime;
    var modal = $(this);
    modal.find('#trainingId').val(trainingId);
    modal.find('#trainerName').text(trainerName);
    modal.find('#trainingDate').val(trainingDate);
    modal.find('#trainingTime').val(trainingTime);
});

$('#modalRating').on('show.bs.modal', function (e) {
    var trainingId = e.relatedTarget.dataset.trainingid;
    var trainerId = e.relatedTarget.dataset.trainerid;
    var modal = $(this);
    modal.find('#trainingId').val(trainingId);
    modal.find('#trainerId').val(trainerId);
});

$('#modalDescription').on('show.bs.modal', function (e) {
    var trainingId = e.relatedTarget.dataset.trainingid;
    var trainingDescription = e.relatedTarget.dataset.trainingdescription;
    var modal = $(this);
    modal.find('#trainingId').val(trainingId);
    modal.find('#trainingDescription').val(trainingDescription);
});

$(document).ready(function(){
    $('.rating').rating();
});

function setStars(rating) {
    var stars=$('#ratingInput').next().children();
    for(var i=0;i<5;i++){
        var starObj=$('#ratingInput').next().children()[i];
        if(i<rating){
            $(starObj).removeClass('fa-star-o');
            $(starObj).addClass('fa-star');
        }else{
            $(starObj).addClass('fa-star-o');
            $(starObj).removeClass('fa-star');
        }
    }
}
