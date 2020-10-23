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
    if (role == 'CLIENT') {
        var moneyBalance = e.relatedTarget.dataset.moneybalance;
        var personalDiscount = e.relatedTarget.dataset.personaldiscount;
        var boughtTrainings = e.relatedTarget.dataset.boughttrainings;
        modal.find('#moneyText').text(moneyBalance);
        modal.find('#discountText').text(personalDiscount);
        modal.find('#boughtText').text(boughtTrainings);
    }
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
    if (role == 'TRAINER') {
        var institution = e.relatedTarget.dataset.institution;
        var graduationYear = e.relatedTarget.dataset.graduationyear;
        var instagramLink = e.relatedTarget.dataset.instagramlink;
        var rating = e.relatedTarget.dataset.rating;
        modal.find('#institutionText').text(institution);
        modal.find('#graduationText').text(graduationYear);
        modal.find('#instagramText').text(instagramLink);
        modal.find('#ratingText').text(rating);
    }
});