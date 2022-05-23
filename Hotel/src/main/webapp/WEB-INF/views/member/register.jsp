<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<title>회원가입</title>
</head>
<body>
   <h1>회원가입</h1>
   <form action="register" method="POST">
            <label for="template-contactform-name">아이디</label> 
            <br>
            <input type="text" name="memberUserid" id="memberUserid" 
            	size="35" placeholder="아이디" required="required" maxlength="20">
	 		<br>
	 		<span id="idCheckMsg"></span>
	 		<br>
	 		
            <label for="template-contactform-name">비밀번호</label>
            <br> 
            <input type="password" id="memberPassword" name="memberPassword" size="35"
               placeholder="패스워드" required="required" maxlength="16">
			<br>
			<span id="pwMsg"></span>
			<br>
			
            <label for="template-contactform-name">비밀번호 확인 </label> 
            <br> 
            <input type="password" name="memberPasswordCheck"
               id="memberPasswordCheck" size="35" placeholder="패스워드 확인"
               required="required" maxlength="16">
			<br>
            <span id="pwCheckMsg"></span>
            <br>
            
            <label for="template-contactform-name">이름</label>
            <br> 
            <input type="text" name="memberName" id="memberName" size="35"
               placeholder="이름" required="required">
			<br>
            
            <label for="template-contactform-name">주민번호</label>
            <br> 
            <input type="text" name="memberSSN" id="memberSSN" maxlength="6" size="13" required>
            <label> - </label>
            <input type="password" name="memberSSN" id="memberSSN" maxlength="7" size="13" required>
			<br>
            
            <label for="template-contactform-name">전화번호</label>
            <br> 
			<select name="change_first_phone_num" onchange="select_first_phone_num(this.value);">
				<option value="">선택</option>
				<option value="010">010</option>
				<option value="011">011</option>
				<option value="016">016</option>
				<option value="017">017</option>
				<option value="019">019</option>
	        </select>
            <input type="text" name="memberPhone" id="first_phone_num" size="6" required value="">
            <label> - </label>
            <input type="text" name="memberPhone" id="memberPhone" maxlength="4" size="6" required>
            <label> - </label>
            <input type="text" name="memberPhone" id="memberPhone" maxlength="4" size="6" required>               
			<br>
         	
         	<label for="template-contactform-name">E-mail</label>
         	<br>
         	<input type="text" name="memberEmail" id="memberEmail" size="15" required>
         	<label> @ </label>
         	<input type="text" name="memberEmail" id="select_mEmail" size="15" required>
			<select name="change_email" onchange="select_email(this.value)">
				<option value="" selected>직접 입력</option>
				<option value="naver.com">naver.com</option>
				<option value="nate.com">nate.com</option>
				<option value="daum.net">daum.net</option>
				<option value="google.com">google.com</option>
				<option value="hanmail.net">hanmail.net</option>
				<option value="korea.com">korea.com</option> 
				<option value="gmail.com">gmail.com</option> 
				<option value="kakao.com">kakao.com</option> 
				<option value="yahoo.com">yahoo.com</option>
			</select>
			<br>
			
            <label for="template-contactform-name">우편번호
            <button type="button" class="btn btn-link"
                  onclick="sample2_execDaumPostcode()">우편번호 찾기</button>
            </label>
            <br> 
            <input type="text" name="memberAddress"
               id="sample2_postcode" size="35" placeholder="ex) 19xxx"
               readonly="readonly">
			<br>
            <label for="template-contactform-name">기본주소</label>
            <br> 
            <input type="text" name="memberAddress" id="memberAddress"
               size="35" placeholder="기본주소" required>
			<br>
            <label for="template-contactform-name">동,면,읍</label>
            <br> 
            <input type="text" id="memberAddress" name="memberAddress"
               size="35" placeholder="동,면,읍" required="required">
			<br>
            <label for="template-contactform-name">상세주소</label>
            <br> 
            <input type="text" name="memberAddress"
               id="memberAddress" size="35" placeholder="상세주소"
               required="required">
   		   <br> 
   		   <hr>
   		   <input id="send" type="submit" value="회원가입 완료" disabled>
   </form>
   
   <script type="text/javascript">
   // 아이디 체크
   $(document).ready(function() {
		$("#memberUserid").keyup(function() {
			$("#idCheckMsg").html('');
			var memberUserid = $("#memberUserid").val();
			console.log(memberUserid);
			$.ajax({
				type : 'get',
				url : 'idCheck',
				data : {'memberUserid' : memberUserid},
				success : function(result) {
					console.log(result);
					if(result == "yes"){
						$("#idCheckMsg").html("사용가능한 아이디입니다.");
					} else {
						$("#idCheckMsg").html("이미 사용중인 아이디입니다.");
					}
				}
			}) // end ajax()
		}); // end blur()
	}); // end docuement.ready()
	
	// 비밀번호 메시지
   $(document).ready(function() {
		$("#memberPassword").blur(function() {
			$('#pwMsg').html('');
			var memberPassword = $("#memberPassword").val();
			if(memberPassword == ''){
				$('#pwMsg').html("필수 입력입니다.");
			} else {
				if(memberPassword.length >= 8 && memberPassword.length <= 16){
					$('#pwMsg').html("사용 가능한 비밀번호입니다.");
				} else {
					$('#pwMsg').html("비밀번호는 8글자 ~ 16글자로 입력해주세요.");
				}
			}
		}); // end blur()
	}); //end document.ready()
   
	// 비밀번호 체크 메시지
	 $(document).ready(function() {
		$("#memberPasswordCheck").blur(function() {
			$('#pwCheckMsg').html('');
			var memberPasswordCheck = $("#memberPasswordCheck").val();
			var memberPassword = $("#memberPassword").val();
			if(memberPasswordCheck == ''){
				$('#pwCheckMsg').html("필수 입력입니다.");
			} else{
				if(memberPasswordCheck.length >= 8 && memberPasswordCheck.length <= 16){
					if(memberPasswordCheck == memberPassword){
						$('#pwCheckMsg').html("비밀번호가 일치합니다.");
						$('#send').attr('disabled', false);
					}else{
						$('#pwCheckMsg').html("비밀번호가 일치하지 않습니다.");
					}
				}else{
					$('#pwCheckMsg').html("비밀번호는 8글자 ~ 16글자로 입력해주세요.");
				}
			}
		}); // end blur()
	}); //end document.ready()
   	
		// 핸드폰 번호 앞자리 선택
		function select_first_phone_num(value){
			console.log(value);
			if(value == ""){
				$('#first_phone_num').val(value);
				$('#first_phone_num').removeAttr('readonly');
			} else {
				$('#first_phone_num').val(value);
				$('#first_phone_num').attr('readonly', 'readonly');				
			}		
		}
		
		// 이메일 선택
		function select_email(value) {
			console.log(value)
			if(value == ""){
				$('#select_mEmail').val(value);
				$('#select_mEmail').removeAttr('readonly');
			} else {
				$('#select_mEmail').val(value);
				$('#select_mEmail').attr('readonly', 'readonly');
			}
		}
	</script>
   
    <div id="layer" style="display:none;position:fixed;overflow:hidden;z-index:1;-webkit-overflow-scrolling:touch;">
      	<img src="//t1.daumcdn.net/postcode/resource/images/close.png" id="btnCloseLayer" style="cursor:pointer;position:absolute;right:-3px;top:-3px;z-index:1" onclick="closeDaumPostcode()" alt="닫기 버튼">
    </div>
               
               <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
               <script>
                   // 우편번호 찾기 화면을 넣을 element
                   var element_layer = document.getElementById('layer');
               
                   function closeDaumPostcode() {
                       // iframe을 넣은 element를 안보이게 한다.
                       element_layer.style.display = 'none';
                   }
               
                   function sample2_execDaumPostcode() {
                       new daum.Postcode({
                           oncomplete: function(data) {
                               // 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
               
                               // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                               // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                               var addr = ''; // 주소 변수
                               var extraAddr = ''; // 참고항목 변수
               
                               //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                               if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                                   addr = data.roadAddress;
                               } else { // 사용자가 지번 주소를 선택했을 경우(J)
                                   addr = data.jibunAddress;
                               }
               
                               // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                               if(data.userSelectedType === 'R'){
                                   // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                                   // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                                   if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                                       extraAddr += data.bname;
                                   }
                                   // 건물명이 있고, 공동주택일 경우 추가한다.
                                   if(data.buildingName !== '' && data.apartment === 'Y'){
                                       extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                                   }
                                   // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                                   if(extraAddr !== ''){
                                       extraAddr = ' (' + extraAddr + ')';
                                   }
                                   // 조합된 참고항목을 해당 필드에 넣는다.
                                   document.getElementById("memberAddress").value = extraAddr;
                               
                               } else {
                                   document.getElementById("memberAddress").value = '';
                               }
               
                               // 우편번호와 주소 정보를 해당 필드에 넣는다.
                               document.getElementById('sample2_postcode').value = data.zonecode;
                               document.getElementById("memberAddress").value = addr;
                               // 커서를 상세주소 필드로 이동한다.
                               document.getElementById("memberAddress").focus();
               
                               // iframe을 넣은 element를 안보이게 한다.
                               // (autoClose:false 기능을 이용한다면, 아래 코드를 제거해야 화면에서 사라지지 않는다.)
                               element_layer.style.display = 'none';
                           },
                           width : '100%',
                           height : '100%',
                           maxSuggestItems : 5
                       }).embed(element_layer);
               
                       // iframe을 넣은 element를 보이게 한다.
                       element_layer.style.display = 'block';
               
                       // iframe을 넣은 element의 위치를 화면의 가운데로 이동시킨다.
                       initLayerPosition();
                   }
               
                   // 브라우저의 크기 변경에 따라 레이어를 가운데로 이동시키고자 하실때에는
                   // resize이벤트나, orientationchange이벤트를 이용하여 값이 변경될때마다 아래 함수를 실행 시켜 주시거나,
                   // 직접 element_layer의 top,left값을 수정해 주시면 됩니다.
                   function initLayerPosition(){
                       var width = 300; //우편번호서비스가 들어갈 element의 width
                       var height = 400; //우편번호서비스가 들어갈 element의 height
                       var borderWidth = 5; //샘플에서 사용하는 border의 두께
               
                       // 위에서 선언한 값들을 실제 element에 넣는다.
                       element_layer.style.width = width + 'px';
                       element_layer.style.height = height + 'px';
                       element_layer.style.border = borderWidth + 'px solid';
                       // 실행되는 순간의 화면 너비와 높이 값을 가져와서 중앙에 뜰 수 있도록 위치를 계산한다.
                       element_layer.style.left = (((window.innerWidth || document.documentElement.clientWidth) - width)/2 - borderWidth) + 'px';
                       element_layer.style.top = (((window.innerHeight || document.documentElement.clientHeight) - height)/2 - borderWidth) + 'px';
                   }
               </script>
</body>
</html>