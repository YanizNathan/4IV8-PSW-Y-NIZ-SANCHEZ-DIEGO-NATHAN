<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body translate="no" >
    <!-- Mixins-->
  <!-- Pen Title-->
  <div class="pen-title">
    <h1>Material Login Form</h1><span>Pen <i class='fa fa-code'></i> by <a href='http://andytran.me'>Andy Tran</a></span>
  </div>
  <div class="rerun"><a href="">Rerun Pen</a></div>
  <div class="container">
    <div class="card"></div>
    <div class="card">
      <h1 class="title">Login</h1>
      <form>
        <div class="input-container">
          <input type="#{type}" id="#{label}" required="required"/>
          <label for="#{label}">Username</label>
          <div class="bar"></div>
        </div>
        <div class="input-container">
          <input type="#{type}" id="#{label}" required="required"/>
          <label for="#{label}">Password</label>
          <div class="bar"></div>
        </div>
        <div class="button-container">
          <button><span>Go</span></button>
        </div>
        <div class="footer"><a href="#">Forgot your password?</a></div>
      </form>
    </div>
    <div class="card alt">
      <div class="toggle"></div>
      <h1 class="title">Register
        <div class="close"></div>
      </h1>
      <form>
        <div class="input-container">
          <input type="#{type}" id="#{label}" required="required"/>
          <label for="#{label}">Username</label>
          <div class="bar"></div>
        </div>
        <div class="input-container">
          <input type="#{type}" id="#{label}" required="required"/>
          <label for="#{label}">Password</label>
          <div class="bar"></div>
        </div>
        <div class="input-container">
          <input type="#{type}" id="#{label}" required="required"/>
          <label for="#{label}">Repeat Password</label>
          <div class="bar"></div>
        </div>
        <div class="button-container">
          <button><span>Next</span></button>
        </div>
      </form>
    </div>
  </div>
  <!-- Portfolio--><a id="portfolio" href="http://andytran.me/" title="View my portfolio!"><i class="fa fa-link"></i></a>
  <!-- CodePen--><a id="codepen" href="https://codepen.io/andytran/" title="Follow me!"><i class="fa fa-codepen"></i></a>
      <script src="https://cpwebassets.codepen.io/assets/common/stopExecutionOnTimeout-8216c69d01441f36c0ea791ae2d4469f0f8ff5326f00ae2d00e4bb7d20e24edb.js"></script>
  
    <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
        <script id="rendered-js" >
  $('.toggle').on('click', function () {
    $('.container').stop().addClass('active');
  });
  
  $('.close').on('click', function () {
    $('.container').stop().removeClass('active');
  });
  //# sourceURL=pen.js
      </script>
  
    
  
  </body>
  
  </html>