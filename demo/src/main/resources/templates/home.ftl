<!doctype html>
<html class="no-js">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <base href="/">
    <title></title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">
    <!-- bower:css -->
    <link rel="stylesheet" href="libs/bower_components/bootstrap/dist/css/bootstrap.css" />
    <link rel="stylesheet" href="libs/bower_components/font-awesome/css/font-awesome.css" />
    <link rel="stylesheet" href="app/bootstrap.icon-large.min.css" />
    <!-- endbower -->
    <!-- app css -->
    <link rel="stylesheet" href="app/app.css">
    <link rel="stylesheet" href="app/main/main.css">
    <link rel="stylesheet" href="app/navbar/navbar.css">
</head>
<body ng-app="RecoApp">
<div ui-view=""></div>

<!-- libs -->
<script src="libs/bower_components/jquery/dist/jquery.js"></script>
<script src="libs/bower_components/angular/angular.js"></script>
<script src="libs/bower_components/angular-resource/angular-resource.js"></script>
<script src="libs/bower_components/angular-cookies/angular-cookies.js"></script>
<script src="libs/bower_components/angular-sanitize/angular-sanitize.js"></script>
<script src="libs/bower_components/angular-bootstrap/ui-bootstrap-tpls.js"></script>
<script src="libs/bower_components/angular-ui-router/release/angular-ui-router.js"></script>
<script src="libs/bower_components/lodash/dist/lodash.compat.js"></script>
<!-- ./libs -->


<!-- app -->
<script src="app/app.js"></script>
<script src="app/main/main.controller.js"></script>
<script src="app/main/main.js"></script>
<script src="app/navbar/navbar.controller.js"></script>
          
</body>
</html>