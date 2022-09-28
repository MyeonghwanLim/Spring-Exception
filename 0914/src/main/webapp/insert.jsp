<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body class="is-preload">

		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Main -->
					<div id="main">

						<!-- Introduction -->
							<section id="intro" class="main">
								<div class="spotlight">
									<div class="content">
										<header class="major">
											<h2>글작성하기</h2>
										</header>
										<form action="insert.do" method="post" enctype="multipart/form-data">
										<table class="alt">
												<tbody>
													<tr>
														<td>글제목</td>
														<td colspan="2"><input type="text" name="title" required></td>
													</tr>
													<tr>
														<td>내용</td>
														<td colspan="2"><input type="text" name="content" required></td>
													</tr>
													<tr>
														<td>작성자</td>
														<td colspan="2"><input type="text" name="writer"  value="${data.name}"required></td>
													</tr>
													<tr>
														<td>파일</td>
														<td colspan="2"><input type="file" name="uploadFile"onchange="loadFile(this)"></td>
														<td><img alt="미리보기" id="preview" style="margint-top:1%;"/></td>
													</tr>
													
													<tr>
														<td colspan="3" align="right"><input type="submit" class="button primary" value="글등록"> </td>
													</tr>
												</tbody>
										</table>
										</form>
										<a href="login.jsp">go to login</a>
									</div>
									<span class="image"><img src="images/pic01.jpg" alt="" /></span>
								</div>
							</section>

					</div>

			 <script type="text/javascript">
   function loadFile(input){
      // 여러개의 이미지를 읽을수도 있기 때문에 
      if(input.files && input.files[0]){
         var fr = new FileReader();
         //파일리더로 일고 읽는게 완료되면  만들어준 아이디에 속성값을 지정하여 사용하겠다.
         fr.onload=function(event){
            document.getElementById('preview').src=event.target.result;
         };
         fr.readAsDataURL(input.files[0]);
         // 이미지파일을 읽어 온다.
      }
      else{
         document.getElementById('preview').src="";
      }
   }
</script>	

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/jquery.scrolly.min.js"></script>
			<script src="assets/js/browser.min.js"></script>
			<script src="assets/js/breakpoints.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>

	</body>
</html>