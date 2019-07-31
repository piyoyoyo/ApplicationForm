$(function() {
  // テキストボックスにフォーカス時、フォームの背景色を変化
  $('#name, #address, #phone')
    .focusin(function(e) {
      $(this).css('background-color', '#ffc');
      console.log(e);
    })
    .focusout(function(e) {
      $(this).css('background-color', '');
    });

  let validName = false
  let validAddress = false
  let validPhone = false

  $('#name')
	.focusout(function(e) {
		if($(this).val().length>20) {
			validName = false
			$('#msg-name').text("20文字以内で入力してください").css('color', 'red');
		} else if($(this).val()=="") {
			$('#msg-name').text("必須項目です").css('color', 'red');
		} else {
			$('#msg-name').text("");
			validName = true
		}
	});
  $('#address')
	.focusout(function(e) {
		if($(this).val().length>50) {
			validAddress = false
			$('#msg-address').text("50文字以内で入力してください").css('color', 'red');
		} else if($(this).val()=="") {
			$('#msg-address').text("必須項目です").css('color', 'red');
		} else {
			$('#msg-address').text("");
			validAddress = true
		}
	});
  $('#phone')
	.focusout(function(e) {
		if(!$(this).val().match(/^[0-9]+$/)) {
			$('#msg-phone').css('color', 'red');
			$('#msg-phone').text("数字で入力してください。");
			validPhone = false
		} else {
			$('#msg-phone').text("");
			validPhone = true
		}
	});

  $('input').focusout(function(){
	  if(validPhone && validAddress && validName){
		  $('#btn')
		  	.prop("disabled", false);
	  } else {
		  $('#btn')
		  	.prop("disabled", true);
	  }
  });

  //郵便番号検索
      //検索ボタンをクリックされたときに実行
      $("#search_btn").click(function () {
          //入力値をセット
          var param = {zipcode: $('#zipcode').val()}
          //zipcloudのAPIのURL
          var send_url = "http://zipcloud.ibsnet.co.jp/api/search";
          $.ajax({
              type: "GET",
              cache: false,
              data: param,
              url: send_url,
              dataType: "jsonp",
              success: function (res) {
                  //結果によって処理を振り分ける
                  if (res.status == 200) {
                      //処理が成功したとき
                      //該当する住所を表示
                      var html = '';
                      for (var i = 0; i < res.results.length; i++) {
                          var result = res.results[i];
                          console.log(res.results);
                          $('#pref').val(result.prefcode);
                          $('#address2').val(result.address2);
                          $('#address3').val(result.address3);
                      } 
                  } else {
                      //エラーだった時
                      //エラー内容を表示
                      $('#zip_result').html(res.message);
                  }
              },
              error: function (XMLHttpRequest, textStatus, errorThrown) {
                  console.log(XMLHttpRequest);
              }
          });
      });
});