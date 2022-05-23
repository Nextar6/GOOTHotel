<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
ul, li{
   list-style:none;
   padding-left:0px;
}
a {
	color: #FFFF02;
	font-size: 3em;
}
</style>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<title>${vo.hotelTitle }</title>
</head>
<body>
	<a href="../main/main" style="color: #000000;">HOTEL</a>
	<h2>${vo.hotelTitle }</h2>
	<c:if test="${not empty admin }">
		<button id="btn_update">수정</button>
		<button id="btn_delete">삭제</button>
	</c:if>
	<c:if test="${not empty userid }">
		<button id="btn_reservat">예약 하기</button>
		<c:if test="${not empty rlist }">
			<button id="btn_review">리뷰 작성</button>
		</c:if>
	</c:if>
	<hr>
	<button id="btn_showDetail">호텔 정보 보기</button>
	<button id="btn_showReview">리뷰 보기</button>
	<div class="showDetail" style="display;">
	<div>
		<p>등급  : ${vo.hotelGrade }</p>
	</div>
	<div>
		<p>가격(1일) : ${vo.hotelPriceNight } $</p>
	</div>
	<div>
		<p>가격(1인당) : ${vo.hotelPricePeople } $</p>
	</div>
	<div>
		<p>패키지 : ${vo.hotelPackage }</p>
	</div>
	<div id="showlist">
	</div>
	<div>
		<p>내용 : ${vo.hotelContent }</p>
	</div>
	<div>
		<p>위치 : ${vo.hotelAddress }</p>
	</div>
		<div id="map" style="width:400px;height:400px;"></div>
	</div>
	<div class="showReview" style="display: none;">
		<p>리뷰</p>
		<c:forEach var="list" items="${list }">
				<input type="hidden" id="reviewNo" value="${list.reviewNo}">
				<input type="hidden" id="hotelNo" value="${list.hotelNo }">
				<input type="hidden" id="reviewWriter" value="${list.reviewWriter }">
			<ul class="reviewTop" style="height: auto; min-height: 70px; width: 80%; border:2px solid black;">
				<li>호텔 이름 : ${list.hotelNo}</li>
				<fmt:formatDate value="${list.reviewCdate }" 
						pattern="yyyy-MM-dd HH:mm:ss" var="reviewCdate"/>
				<li>작성일 : ${reviewCdate }</li>
				<li style="float: right;">작성자 : ${list.reviewWriter}</li>
				<c:if test="${userid eq list.reviewWriter}">
					<li style="float: right;">
					<a href="../review/update?reviewNo=${list.reviewNo }"><input type="button" value="수정"></a>
					<a href="../review/delete?reviewNo=${list.reviewNo }&reviewWriter=${list.reviewWriter}"><input type="button" value="삭제"></a>
					</li>
				</c:if>
				<c:choose>
					<c:when test="${list.reviewGrade eq '1'}">
						<li>평점 : <a>★</a><a style="color: #F0F0F0;">☆☆☆☆</a></li>
					</c:when>
					<c:when test="${list.reviewGrade eq '2'}">
						<li>평점 : <a>★★</a><a style="color: #F0F0F0;">☆☆☆</a></li>
					</c:when>
					<c:when test="${list.reviewGrade eq '3'}">
						<li>평점 : <a>★★★</a><a style="color: #F0F0F0;">☆☆</a></li>
					</c:when>
					<c:when test="${list.reviewGrade eq '4'}">
						<li>평점 : <a>★★★★</a><a style="color: #F0F0F0;">☆</a></li>
					</c:when>
					<c:when test="${list.reviewGrade eq '5'}">
						<li>평점 : <a>★★★★★</a></li>
					</c:when>
				</c:choose>
			</ul>
			<ul id="reviewMain" style="height: auto; min-height: 300px; width: 80%; border:2px solid black;">
				<li>
					<c:if test="${not empty list.reviewPic }">
						<c:set var="image" value="${list.reviewPic}"/>
						<c:set var="images" value="${fn:replace(image, '/thumbnail_', '/')}"/>
						<c:set var="a" value="${fn:split(images, ',')}"/>
						<c:if test="${not fn:contains(image, ',')}">
								<img src="displayimages?fileName=${images}">
						</c:if>
						<c:if test="${fn:contains(image, ',')}">
							<c:forEach var="a" items="${a}">
								<img src="displayimages?fileName=${a}">
							</c:forEach>
						</c:if>
					</c:if>
				</li>
				<li>${list.reviewContent }</li>
			</ul>
			<br>
		</c:forEach>
	</div>
	
	<input type="hidden" id="hotelNo" value="${vo.hotelNo }">
	<input type="hidden" id="hotelPic" value="${vo.hotelPic }">
	<input type="hidden" id="updateAlert" value="${update_hotel }">
	<input type="hidden" id="deleteAlert" value="${delete_hotel }">
	
	<script type="text/javascript">	
		$(document).ready(function() {
			$('#btn_showDetail').click(function() {
				if($('.showDetail').css('display') == 'none'){
					$('.showDetail').show();
					$('.showReview').hide();
				}
			});
		}); // end document.ready()
	
		$(document).ready(function() {
			$('#btn_showReview').click(function() {
				if($('.showReview').css('display') == 'none'){
					$('.showReview').show();
					$('.showDetail').hide();
				}
			});
		}); // end document.ready()
		
		
	
		$(document).ready(function() {
			var a = $('#hotelPic').val();
			if(a != null){
				var image = a.split("thumbnail_");
				var join = '';
				for(var i = 0; i < image.length; i++){
						join += image[i];
				}
				
				var images = join.split(",");
				var str = '';
				for(var i = 0; i < images.length; i++){
					str += '<div>' 
						+ '<img src="displayimages?fileName='
						+ images[i] 
						+ '"/>'
						+ '</div>';
				}
				$('#showlist').html(str);
			}
		}); // end document.ready()
		
		$(document).ready(function() {
			$('#btn_update').click(function() {
				location = '../hotel/update?hotelNo=${vo.hotelNo}';
			}); // end btn_update.click()
			$('#btn_delete').click(function() {
				location = '../hotel/delete?hotelNo=${vo.hotelNo}'
			}); // end btn_delete.click()
			$('#btn_review').click(function() {
				location = '../review/register?hotelNo=${vo.hotelNo}&reviewWriter=${userid}';
			}); // end btn_review.click()
			$('#btn_reservat').click(function() {
				location = '../reservat/register?hotelNo=${vo.hotelNo}&reservatUserid=${userid}';
			}); // end btn_reservation.click()
		}); // end document.ready()

		
	
		
		$(document).ready(function() {
			var result = $('#updateAlert').val();
			if(result == "success"){
				alert('호텔 정보 수정 성공 !');
			}
		});
		
		$(document).ready(function() {
			var result = $('#deleteAlert').val();
			if(result == "fail"){
				alert('호텔 삭제 실패 !');
			}
		});
	
	</script>
	
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=8a6852e5eee01b8c5c3f3c614c118dcc&libraries=services"></script>
	<script>
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };  

	// 지도를 생성합니다    
	var map = new kakao.maps.Map(mapContainer, mapOption); 
	
	// 주소-좌표 변환 객체를 생성합니다
	var geocoder = new kakao.maps.services.Geocoder();
	
	// 주소로 좌표를 검색합니다
	geocoder.addressSearch('${vo.hotelAddress}', function(result, status) {
	
	    // 정상적으로 검색이 완료됐으면 
	     if (status === kakao.maps.services.Status.OK) {
	
	        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
	
	        // 결과값으로 받은 위치를 마커로 표시합니다
	        var marker = new kakao.maps.Marker({
	            map: map,
	            position: coords
	        });
	
	        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
	        map.setCenter(coords);
	    } 
	});    
	</script>
</body>
</html>