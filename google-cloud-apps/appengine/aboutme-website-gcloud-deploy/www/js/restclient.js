function addContactQuery() {
	// alert("HELLO");
	var userId = '30004';
	var name = $('#contact_name_input').val();
	var email = $('#contact_email_input').val();
	var emailSubject = $('#contact_email_subject_input').val();
	var queryTxt = $('#contact_text_area_input').val();

	var postData = {
		"userId" : userId,
		"contactName" : name,
		"contactEmailAddress" : email,
		"contactQuerySubject" : emailSubject,
		"contactQueryText" : queryTxt
	};

	alert("Are you sure you want to contact me!!");
	$.ajax({
		url : 'http://localhost:8080/goodpluto/api/queries/put',
		type : 'POST',
		contentType : 'application/json',
		data : JSON.stringify(postData),
		success : function() {
			console.write("post success");
		},
		error : function() {
			console.write("post error");
		}
	});
	alert("Query Sent to me. I will revert back!!");
};
