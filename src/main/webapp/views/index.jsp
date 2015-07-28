<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html lang="en" ng-app="labApp">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>My AngularJS App</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="bower_components/html5-boilerplate/css/normalize.css">
    <link rel="stylesheet" href="bower_components/html5-boilerplate/css/main.css">
    <link rel="stylesheet" href="app.css">
    <link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.css">
    <script src="bower_components/html5-boilerplate/js/vendor/modernizr-2.6.2.min.js"></script>
    <script src="bower_components/angular/angular.js"></script>
    <script src="bower_components/angular-route/angular-route.js"></script>
    <script src="bower_components/angular-resource/angular-resource.js"></script>
    <script src="bower_components/angular-cookies/angular-cookies.js"></script>
    <script src="bower_components/jquery/dist/jquery.min.js"></script>
    <script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="bower_components/ng-flow/dist/ng-flow-standalone.js"></script>

    <script src="app.js"></script>
    <script src="js/productController.js"></script>
    <script src="js/productService.js"></script>



    <!-- add i18n script -->
    <script src="bower_components/angular-translate/angular-translate.js"></script>
    <script src="bower_components/angular-translate-loader-url/angular-translate-loader-url.js"></script>
    <script src="js/languageServices.js"></script>
    <script src="js/languageControllers.js"></script>
    <script src="js/shoppingCartController.js"></script>
    <script src="js/shoppingCartService.js"></script>
    <script src="js/securityController.js"></script>
    <script src="js/registerController.js"></script>
    <script src="js/registerService.js"></script>

</head>
<body>
<div class="page-header">
    <h1>CAMT
        <small>Software Component Based Software Development</small>
    </h1>

</div>
<div class="navbar navbar-default" ng-controller="languageController">
    <div class="container-fluid">
            <div class="collapse navbar-collapse">
                <div class="col-md-9 col-md-offset-2" ng-controller="loginController" >
                    <form class="form-inline" ng-hide="user"  >
                        <div class="form-group ">
                            <label for="username" class="col-sm-3 control-label">User Name:</label>
                            <div class="col-sm-3">
                                <input id="username" ng-model="username" type="text" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="password" class="col-sm-3 control-label">Password:</label>
                            <div class="col-sm-3">
                                <input id="password" ng-model="password" type="password" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-3 col-sm-offset-3">
                                <input type="submit" value="Log In" class="btn btn-primary" ng-click="login()"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-9 col-sm-9">
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" ng-model="rememberMe"> Remember me
                                    </label>
                                </div>
                            </div>
                        </div>
                    </form>
                    <form class="form-inline" ng-show="user" >
                        <div class="H6 col-sm-5 col-sm-offset-3 text-right">
                            Hello !!! {{user.name}}
                        </div>
                        <div class="form-group">
                            <div class="col-sm-3 ">
                                <input type="submit" value="Log Out" class="btn btn-primary" ng-click="logout()"/>
                            </div>
                        </div>

                    </form>
                </div>
                <div class="collapse navbar-collapse" ng-controller="languageController">
                <ul class="nav navbar-nav navbar-right">
                    <li ng-class="{'active':currentLocale== 'en'}"><a href="" ng-click="changeLanguage('en')">EN </a></li>
                    <li ng-class="{'active':currentLocale== 'fr'}"><a href="" ng-click="changeLanguage('fr')">FR</a></li>
                </ul>
            </div>
    </div>
</div>
    <div class="container ng-hide" ng-show="initialized">
        <div class="alert alert-danger" ng-show="error">{{error}}</div>
    </div>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-2">
            <!-- Fixed left nav column -->
            <div ng-include src="'template/leftnav.html'"></div>
        </div>
        <div class="col-md-10">
            <!-- Breadcrumbs
           ================================================== -->


            <ng-view>Loading...</ng-view>

        </div>
    </div>
</div>


<!-- In production use:
<script src="//ajax.googleapis.com/ajax/libs/angularjs/x.x.x/angular.min.js"></script>
-->

</div>
</body>
</html>
