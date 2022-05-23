<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<title>reservatUpdate</title>
</head>
<body>
	<h1>예약 수정</h1>
	<form action="update" method="post">
		<input type="hidden" name="reservatUserid" value="${vo.reservatUserid }">
		<input type="hidden" name="hotelNo" value="${vo.hotelNo }">
		<input type="hidden" name="reservatNo" value="${vo.reservatNo }">
		<p>호텔 이름 : ${hvo.hotelTitle }</p>
		<p>예약자 : ${vo.reservatUserid }</p>	
		<p>1인 당 호텔 가격 : ${hvo.hotelPricePeople }</p>
		<p>예약 인원</p>
		<input type="number" name="reservatPeople" id="reservatPeople">
		<br>
		<p>1일 당 호텔 가격 : ${hvo.hotelPriceNight }</p>
		<label for="checkIn">체크인 날짜</label>
		<br>
		<input type="date" name="checkIn" id="checkIn" value="">
		<br>
		<span id="checkInMsg"></span>
		<br>
		<label for="checkOut">체크아웃 날짜</label>
		<br>
		<input type="date" name="checkOut" id="checkOut">
		<br>
		<span id="checkOutMsg"></span>
		<br>
		일 수 : <input type="text" id="days" name="reservatNight" readonly>
		<hr>
		<p>총 가격<p>
		<input type="number" name="reservatPrice" id="reservatPrice" readonly>
		<hr>
		<input type="submit" value="수정">
	</form>
		<input type="hidden" id="hotelPriceNight" value="${hvo.hotelPriceNight}">
		<input type="hidden" id="hotelPricePeople" value="${hvo.hotelPricePeople}">
		
	<script type="text/javascript">
		$(document).ready(function() {
			var pricePeople = $('#hotelPricePeople').val();
			var priceNight = $('#hotelPriceNight').val();
			
			$('#reservatPeople').on('change', function() {
				var checkIn = $('#checkIn').val();
				var checkOut = $('#checkOut').val();
				var peopleCount = $('#reservatPeople').val();
			
				if(checkOut != '' && checkIn != ''){
					var checkIn_arr = checkIn.split("-");
					var checkOut_arr = checkOut.split("-");
						
					var In = new Date(checkIn_arr[0], checkIn_arr[1], checkIn_arr[2]);
					var Out = new Date(checkOut_arr[0], checkOut_arr[1], checkOut_arr[2]);					
					var time = Out.getTime() - In.getTime(); 
					var times = time / (1000 * 3600 * 24);
			
					var night = priceNight * times;
					var people = pricePeople * peopleCount;
					$('#reservatPrice').val(people + night);
				} else {
					var people = pricePeople * peopleCount;
					$('#reservatPrice').val(people);					
				}
			}); // end reservatPeople.onblur
			
			$('#checkIn').on('change', function() {
				$('#days').val('');
				$('#checkInMsg').html('');
				$('#checkOutMsg').html('');
				var checkIn = $('#checkIn').val();
				var checkOut = $('#checkOut').val();
				var peopleCount = $('#reservatPeople').val();
				
				if(checkOut == ''){
					$('#checkOutMsg').html("체크아웃 날짜를 설정해주세요.");
				} else {
						var checkIn_arr = checkIn.split("-");
						var checkOut_arr = checkOut.split("-");
							
						var In = new Date(checkIn_arr[0], checkIn_arr[1], checkIn_arr[2]);
						var Out = new Date(checkOut_arr[0], checkOut_arr[1], checkOut_arr[2]);					
						var time = Out.getTime() - In.getTime(); 
						var times = time / (1000 * 3600 * 24);
				
						if(times >= 0){
							var night = priceNight * times;
							var people = pricePeople * peopleCount;
							
							$('#days').val(times);
							$('#reservatPrice').val(people + night);
						}
				}
			}); // end checkIn.onchange
			
			$('#checkOut').on('change', function() {
				$('#checkInMsg').html('');
				$('#checkOutMsg').html('');
				$('#days').val('');
				var checkIn = $('#checkIn').val();
				var checkOut = $('#checkOut').val();
				var peopleCount = $('#reservatPeople').val();
				
				if(checkIn != ''){
					var checkIn_arr = checkIn.split("-");
					var checkOut_arr = checkOut.split("-");
						
					var In = new Date(checkIn_arr[0], checkIn_arr[1], checkIn_arr[2]);
					var Out = new Date(checkOut_arr[0], checkOut_arr[1], checkOut_arr[2]);					
					
					var time = Out.getTime() - In.getTime(); 
					var times = time / (1000 * 3600 * 24);
					if(times >= 0){
						var night = priceNight * times;
						var people = pricePeople * peopleCount;
						$('#days').val(times);
						$('#reservatPrice').val(people + night);
					} 
				} else {
					$('#checkInMsg').html('체크인 날짜를 설정해주세요.');
				}
			}); // end checkOut.onchange
			
		}); // end document.ready()
	</script>
</body>
</html>