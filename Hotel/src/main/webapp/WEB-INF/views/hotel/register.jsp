<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<title>호텔등록</title>
</head>
<body>
	<h1>호텔 등록</h1>
	<form action="register" method="post">
		<label>호텔 이름</label>
		<br>
		<input type="text" name="hotelTitle" id="hotelTitle" required autofocus>
		<br>
		<label>호텔 등급</label>
		<br>
		<select name="change_star" onchange="select_grade(this.value)">
			<option value="1">☆</option>
			<option value="2">☆☆</option>
			<option value="3">☆☆☆</option>
			<option value="4">☆☆☆☆</option>
			<option value="5">☆☆☆☆☆</option>
			<option value="6">★☆</option>
			<option value="7">★☆☆</option>
		</select>
		<input type="text" name="hotelGrade" id="hotel_grade" size="8" required value="" placeholder="성급">
		<br>
		<label>호텔 가격(1일)</label>
		<br>
		<input type="number" name="hotelPriceNight" id="hotelPrice" required placeholder="$">
		<br>
		<label>호텔 가격(1인)</label>
		<br>
		<input type="number" name="hotelPricePeople" id="hotelPricePeople" required placeholder="$">
		<br>
		<label>호텔 주소</label>
		<br>
		<label for="template-contactform-name">우편번호
        <button type="button" class="btn btn-link"
                onclick="sample2_execDaumPostcode()">우편번호 찾기</button>
        </label>
        <br> 
        <input type="text" name="hotelAddress1"
             id="sample2_postcode" size="35" placeholder="ex) 19xxx"
             readonly>
		<br>
        <label>기본주소</label>
        <br> 
        <input type="text" name="hotelAddress" id="hotelAddress"
             size="35" placeholder="기본주소" required>
		<br>
        <br>
   		<label>호텔 패키지</label>
   		<br>
   		<input type="checkbox" name="hotelPackage" value="PickUp">PickUp
   		<input type="checkbox" name="hotelPackage" value="Breakfast">Breakfast
   		<input type="checkbox" name="hotelPackage" value="Pool">Pool
   		<input type="checkbox" name="hotelPackage" value="Bar">Bar
   		<input type="checkbox" name="hotelPackage" value="Lounge">Lounge
   		<input type="checkbox" name="hotelPackage" value="Tour">Tour
   		<input type="checkbox" name="hotelPackage" value="LanterCar">LanterCar
   		<input type="checkbox" name="hotelPackage" value="FreeLaundry">FreeLaundry
   		<br>
   		<label>호텔 내용</label>
   		<br>
   		<input type="text" name="hotelContent" id="hotelContent" required>
   		<br>
   		<label>호텔 이미지</label>
   		<br>
		<input type="file" name="fileUpload" id="fileUpload" multiple>
		<input type="hidden" name="hotelPic" id="hotelPic">
		<div id="showlist">
		</div>
   		<br>
   		<hr>
		<input type="submit" value="등록">		
	</form>

	<script type="text/javascript">
		$(document).ready(function() {
			$('#fileUpload').on('change', function(event) {
				var formData = new FormData();
				var fileinput = $('#fileUpload');
				var filelist = fileinput[0].files;
				
				for(var i = 0; i < filelist.length; i++){
					console.log(filelist[i]);
					formData.append("filelist", filelist[i]);
				}
								
				$.ajax({
					type : 'POST',
					url : 'fileUpload',
					async : false,
					processData : false,
					contentType : false,
					data : formData,
					success : function(data) {
						console.log(data);
						var str = '<div>';
						for(var i = 0; i < filelist.length; i++){
							str += '<img src="display?fileName='
								+ data[i]
								+ '"/>';
						}
						str	+ '</div>';
						$('#showlist').html(str);
						$('#hotelPic').val(data);
					}
				})// end ajax
			}); // end fileUpload.change
		}); // end document	
		
		function select_grade(value) {
			console.log(value);
			if(value != ""){
				$('#hotel_grade').val(value);
				$('#hotel_grade').attr('readonly', 'readonly');
			} else {
				$('#hotel_grade').val(value);
				$('#hotel_grade').removeAttr('readonly');
			}
		}
	</script>

	<div id="layer" style="display:none;position:fixed;overflow:hidden;z-index:1;-webkit-overflow-scrolling:touch;">
      	<img src="//t1.daumcdn.net/postcode/resource/images/close.png" id="btnCloseLayer" style="cursor:pointer;position:absolute;right:-3px;top:-3px;z-index:1" onclick="closeDaumPostcode()" alt="닫기 버튼">
    </div>
               
    <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script>
                   var element_layer = document.getElementById('layer');
               
                   function closeDaumPostcode() {
                       element_layer.style.display = 'none';
                   }
               
                   function sample2_execDaumPostcode() {
                       new daum.Postcode({
                           oncomplete: function(data) {
                               var addr = ''; 
                               var extraAddr = ''; 
               
                               if (data.userSelectedType === 'R') { 
                                   addr = data.roadAddress;
                               } else { 
                                   addr = data.jibunAddress;
                               }
               
                               if(data.userSelectedType === 'R'){
                                   if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                                       extraAddr += data.bname;
                                   }
                                   if(data.buildingName !== '' && data.apartment === 'Y'){
                                       extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                                   }
                                   if(extraAddr !== ''){
                                       extraAddr = ' (' + extraAddr + ')';
                                   }
                                   document.getElementById("hotelAddress").value = extraAddr;
                               
                               } else {
                                   document.getElementById("hotelAddress").value = '';
                               }
               
                               document.getElementById('sample2_postcode').value = data.zonecode;
                               document.getElementById("hotelAddress").value = addr;
                               document.getElementById("hotelAddress").focus();
               
                               element_layer.style.display = 'none';
                           },
                           width : '100%',
                           height : '100%',
                           maxSuggestItems : 5
                       }).embed(element_layer);
               
                       element_layer.style.display = 'block';
               
                       initLayerPosition();
                   }
               
                   function initLayerPosition(){
                       var width = 300; 
                       var height = 400; 
                       var borderWidth = 5; 
               
                       element_layer.style.width = width + 'px';
                       element_layer.style.height = height + 'px';
                       element_layer.style.border = borderWidth + 'px solid';
                       element_layer.style.left = (((window.innerWidth || document.documentElement.clientWidth) - width)/2 - borderWidth) + 'px';
                       element_layer.style.top = (((window.innerHeight || document.documentElement.clientHeight) - height)/2 - borderWidth) + 'px';
                   }
      </script>
</body>
</html>