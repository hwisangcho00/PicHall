<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<!--
   Massively by Pixelarity
   pixelarity.com | hello@pixelarity.com
   License: pixelarity.com/license
-->
<html>
<head>
<title>Untitled</title>
<meta charset="utf-8" />
<meta name="viewport"
   content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="assets/css/main.css" />
<style>
ul{
   list-style: none;
   margin: none;
}
a{
   border-bottom: none;
}
.modal {
   display: none; /* Hidden by default */
   position: fixed; /* Stay in place */
   z-index: 1; /* Sit on top */
   left: 0;
   top: 0;
   width: 100%; /* Full width */
   height: 100%; /* Full height */
   overflow: auto; /* Enable scroll if needed */
   background-color: rgb(0, 0, 0); /* Fallback color */
   background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
}
/* Modal Content/Box */
.modal-content {
   background-color: #fefefe;
   margin: 15% auto; /* 15% from the top and centered */
   padding: 20px;
   border: 1px solid #888;
   width: 50%; /* Could be more or less, depending on screen size */
   z-index: 10004;
}
/* The Close Button */
.close {
   color: #aaa;
   float: right;
   font-size: 28px;
   font-weight: bold;
}

.close:hover, .close:focus {
   color: black;
   text-decoration: none;
   cursor: pointer;
}
#dragandrophandler{
    border:2px dotted #0B85A1;
    width:400px;
    color:#92AAB0;
    text-align:left;vertical-align:middle;
    padding:10px 10px 10 10px;
    margin-bottom:10px;
    font-size:200%;
}
</style>
</head>
<body class="is-preload">

   <!-- Wrapper -->
   <div id="wrapper">

      <!-- Header -->
      <header id="header">
         <div class="dropdown active logo">
            <button onclick="myFunction()" href="index.html"class="dropbtn">MAket</button>
            <div id="myDropdown" class="dropdown-content">
               <a href="index.html">Home</a> <a href="generic.html">Generic</a> <a
                  href="elements.html">Elements</a>
            </div>
         </div>
      </header>



      <!-- Main -->
      <div id="main">

         <!-- Post -->
         <section class="post">
            <header class="major">
               <h1>Generic Page</h1>
            </header>


         </section>
         <div class="actions">
            <button class="btn">사진 업로드</button>

            <!-- 첫 번째 Modal -->
            <div class="modal">

               <!-- 첫 번째 Modal의 내용 -->
               <div class="modal-content">
                  <span class="close">&times;</span>
                  <p>사진을 업로드해주세요. 사진이 아닌 파일은 업로드가 불가능합니다.<br>
                  or 다음 형식의 사진만 업로드 가능합니다.(jpg, png, gif, ai 등)</p>
                  <p>(사진이 아닌경우 막는건 아직 구현되지 않았습니다.)</p>
                  <div id="dragandrophandler">Drag & Drop Files Here</div>
                  <br>
                  <div id="status1"></div>
               </div>
            </div>

            <!-- 두 번째 Modal을 여는 클래스 -->
            <button class="btn">음악 업로드</button>

            <!-- 두 번째 Modal -->
            <div class="modal">

               <!-- 두 번째 Modal의 내용 -->
               <div class="modal-content">
                  <span class="close">&times;</span>
                  <p>음악을 업로드해주세요. 저작권이 있는 음악의 업로드에 대해 PicHall은 책임지지 않습니다.</p>
                  <div id="dragandrophandler">Drag & Drop Files Here</div>
                  <br>
                  <div id="status1"></div>
               </div>
            </div>

            <!-- 세 번째 Modal을 여는 클래스 -->
            <button class="btn">팔로우</button>

            <!-- 세 번째 Modal -->
            <div class="modal">

               <!-- 세 번째 Modal의 내용 -->
               <div class="modal-content">
                  <span class="close">&times;</span>
                  <ul>
                     <!-- 팔로우를 클릭하면 상대방에게 이동합니다 -->
                     <li><a href="#">팔로우1</a></li>
                     <li><a href="#">팔로우2</a></li>
                     <li><a href="#">팔로우3</a></li>
                     <li><a href="#">팔로우4</a></li>
                     <li><a href="#">팔로우5</a></li>
                     <li><a href="#">팔로우1</a></li>
                     <li><a href="#">팔로우2</a></li>
                     <li><a href="#">팔로우3</a></li>
                     <li><a href="#">팔로우4</a></li>
                     <li><a href="#">팔로우5</a></li>
                     <li><a href="#">팔로우1</a></li>
                     <li><a href="#">팔로우2</a></li>
                     <li><a href="#">팔로우3</a></li>
                     <li><a href="#">팔로우4</a></li>
                     <li><a href="#">팔로우5</a></li>
                     <li><a href="#">팔로우1</a></li>
                     <li><a href="#">팔로우2</a></li>
                     <li><a href="#">팔로우3</a></li>
                     <li><a href="#">팔로우4</a></li>
                     <li><a href="#">팔로우5</a></li>
                  </ul>
               </div>
            </div>
            
            <!-- 네 번째 Modal을 여는 클래스 -->
            <button class="btn">팔로워</button>

            <!-- 네 번째 Modal -->
            <div class="modal">

               <!-- 네 번째 Modal의 내용 -->
               <div class="modal-content">
                  <span class="close">&times;</span>
                  <ul>
                     <!-- 팔로워를 클릭하면 상대방에게 이동합니다 -->
                     <li><a href="#">팔로워1</a></li>
                     <li><a href="#">팔로워2</a></li>
                     <li><a href="#">팔로워3</a></li>
                     <li><a href="#">팔로워4</a></li>
                     <li><a href="#">팔로워5</a></li>
                  </ul>
               </div>
            </div>
            
            <!-- 다섯 번째 Modal을 여는 클래스 -->
            <button class="btn">여분 모달창</button>

            <!-- 다섯 번째 Modal -->
            <div class="modal">

               <!-- 다섯 번째 Modal의 내용 -->
               <div class="modal-content">
                  <span class="close">&times;</span>
                  <p>다섯 번째 Modal</p>
               </div>
            </div>
         </div>




      </div>




   </div>

   <script src=js/modal.js>
    /*modal.js */
    </script>
   <!-- Scripts -->
   <script src="assets/js/jquery.min.js"></script>
   <script src="assets/js/jquery.scrollex.min.js"></script>
   <script src="assets/js/jquery.scrolly.min.js"></script>
   <script src="assets/js/browser.min.js"></script>
   <script src="assets/js/breakpoints.min.js"></script>
   <script src="assets/js/util.js"></script>
   <script src="assets/js/main.js"></script>
   <script>
      /* When the user clicks on the button, 
      toggle between hiding and showing the dropdown content */
      function myFunction() {
         document.getElementById("myDropdown").classList.toggle("show");
      }

      // Close the dropdown if the user clicks outside of it
      window.onclick = function(event) {
         if (!event.target.matches('.dropbtn')) {
            var dropdowns = document
                  .getElementsByClassName("dropdown-content");
            var i;
            for (i = 0; i < dropdowns.length; i++) {
               var openDropdown = dropdowns[i];
               if (openDropdown.classList.contains('show')) {
                  openDropdown.classList.remove('show');
               }
            }
         }
      }
   </script>
   <script>
   // Modal을 가져옵니다.
   var modals = document.getElementsByClassName("modal");
   // Modal을 띄우는 클래스 이름을 가져옵니다.
   var btns = document.getElementsByClassName("btn");
   // Modal을 닫는 close 클래스를 가져옵니다.
   var spanes = document.getElementsByClassName("close");
   var funcs = [];
    
   // Modal을 띄우고 닫는 클릭 이벤트를 정의한 함수
   function Modal(num) {
     return function() {
       // 해당 클래스의 내용을 클릭하면 Modal을 띄웁니다.
       btns[num].onclick =  function() {
           modals[num].style.display = "block";
           console.log(num);
           $('body').css("overflow", "hidden");
       };
    
       // <span> 태그(X 버튼)를 클릭하면 Modal이 닫습니다.
       spanes[num].onclick = function() {
           modals[num].style.display = "none";
           $('body').css("overflow", "scroll");
       };
     };
   }
    
   // 원하는 Modal 수만큼 Modal 함수를 호출해서 funcs 함수에 정의합니다.
   for(var i = 0; i < btns.length; i++) {
     funcs[i] = Modal(i);
   }
    
   // 원하는 Modal 수만큼 funcs 함수를 호출합니다.
   for(var j = 0; j < btns.length; j++) {
     funcs[j]();
   }
    
   // Modal 영역 밖을 클릭하면 Modal을 닫습니다.
   window.onclick = function(event) {
     if (event.target.className == "modal") {
         event.target.style.display = "none";
         $('body').css("overflow", "scroll");
     }
   };
   </script>
   <script>
var files;

$(document).ready(function(){
    var obj = $("#dragandrophandler");

    obj.on('dragenter', function (e) 
    {
        e.stopPropagation();
        e.preventDefault();
        $(this).css('border', '2px solid #0B85A1');
    });
    obj.on('dragover', function (e) 
    {
        e.stopPropagation();
        e.preventDefault();
    });
    obj.on('drop', function (e) 
    {
    
        $(this).css('border', '2px dotted #0B85A1');
        e.preventDefault(); 
        files = e.originalEvent.dataTransfer.files;

        //We need to send dropped files to Server
        handleFileUpload(files,obj);
    });

    $(document).on('dragenter', function (e) 
    {
        e.stopPropagation();
        e.preventDefault();
    });
    $(document).on('dragover', function (e) 
    {
        e.stopPropagation();
        e.preventDefault();
        obj.css('border', '2px dotted #0B85A1');
    });
    $(document).on('drop', function (e) 
    {
        e.stopPropagation();
        e.preventDefault();
    });
 
});


// 파일 멀티 업로드
function handleFileUpload(files, obj) {
    if(confirm(files.length + "개의 파일을 업로드 하시겠습니까?") ) {
        var data = new FormData();

        data.append('_token', '{{ Session::token() }}');

        for (var i = 0; i < files.length; i++) {
            data.append('file[]', files[i]);
        }

        var url = "{{url('/upload')}}";
        $.ajax({
            url: url,
            method: 'POST',
            data: data,
            dataType: 'json',
            processData: false,
            contentType: false,
            success: function(res) {
                // for(var i=0; i < files.length; i++){
                //     alert(files[i].name + " - " + files[i].size);
                // }
            }
        });

        for(var i=0; i < files.length; i++){
            // 드래그 앤 드롭으로 업로드된 파일 리스트 작성
            // 사진 미리보기는 px부분을 수정하면 됩니다. 미리보기가 있으면 좋긴 하겠는데 리스트 모양이 망가지네요
            $('#status1').append('<div id="file_result_'+i+'"><span>'+files[i].name + " - " + files[i].size+'</span>'+
                '<input type="button" value="삭제" onclick="delete_file('+i+')">'+
                '<img id="file_img_'+i+'" width="100px" height="100px">'+
                '</div>');

            // 이미지 미리보기
            var reader = new FileReader();
            var j=0;
            reader.onload = function(e){
                document.getElementById('file_img_'+j).src = e.target.result;
                // $('#file_img_'+i).attr('src', rst.target.result);
                j++;
            }
            reader.readAsDataURL(files[i]);
        }           

    }
}

//사진 삭제
function delete_file(idx){
    if(confirm(files[idx].name+"을 삭제하시겠습니까?")){
        var data = new FormData();

        data.append('_token', '{{ Session::token() }}');
        data.append('_method', 'DELETE');
        data.append('file_name', files[idx].name);
        
        $.ajax({
            url : "{{url('/upload/1')}}",
            method:'POST',
            data : data,
            dataType: 'json',
            processData: false,
            contentType: false,            
            success : function(data){
                // alert(data);
            }
        });

        $('#file_result_'+idx).remove();
    }
}
</script>
</body>
</html>