'use strict';

var app = angular.module('calculationApp',
    ['calculationControllers', 'ngRoute', 'ui.bootstrap']).
    config(['$routeProvider', '$locationProvider',
        function ($routeProvider, $locationProvider) {
            $routeProvider.
                when('/result', {
                    templateUrl: '/html/calculation.html',
                    controller: 'CalculateCtrl'
                }).
                when('/create', {
                    templateUrl: '/html/productForm.html',
                    controller: 'CreateRecipeCtrl'
                }).
                when('/recipe', {
                    templateUrl: '/html/recipe.html',
                    controller: 'showRecipesCtrl'
                }).
                when('/profile', {
                    templateUrl: '/html/loadRecipe.html',
                    controller: 'LoadRecipe'
                }).
                when('/category', {
                    templateUrl: '/html/productClassification.html',
                    controller: 'loadCategories'
                }).
                otherwise({
                    redirectTo: '/category'
                });

                $locationProvider.html5Mode(true);
        }]);

    app.filter('startFrom', function () {
        /**
         * Extracts an array from the specific index.
         *
         * @param {Array} data
         * @param {Integer} start
         * @returns {Array|*}
         */
        var filter = function (data, start) {
            return data.slice(start);
        }
        return filter;
    });

    /**
     * @ngdoc constant
     * @name HTTP_ERRORS
     *
     * @description
     * Holds the constants that represent HTTP error codes.
     *
     */
    app.constant('HTTP_ERRORS', {
        'UNAUTHORIZED': 401
    });


    /**
     * @ngdoc service
     * @name oauth2Provider
     *
     * @description
     * Service that holds the OAuth2 information shared across all the pages.
     *
     */
    app.factory('oauth2Provider', function ($modal) {
        var oauth2Provider = {
            CLIENT_ID: '167998855239-5eap073ik303b3ohiaisameqtinmghlo.apps.googleusercontent.com',
            SCOPES: 'https://www.googleapis.com/auth/userinfo.email profile',
            signedIn: false
        };

        /**
         * Calls the OAuth2 authentication method.
         */
        oauth2Provider.signIn = function (callback) {
            gapi.auth.signIn({
                'clientid': oauth2Provider.CLIENT_ID,
                'cookiepolicy': 'single_host_origin',
                'accesstype': 'online',
                'approveprompt': 'auto',
                'scope': oauth2Provider.SCOPES,
                'callback': callback
            });
        };

        /**
         * Logs out the user.
         */
        oauth2Provider.signOut = function () {
            gapi.auth.signOut();
            // Explicitly set the invalid access token in order to make the API calls fail.
            gapi.auth.setToken({access_token: ''})
            oauth2Provider.signedIn = false;
        };

        /**
         * Shows the modal with Google+ sign in button.
         *
         * @returns {*|Window}
         */
        oauth2Provider.showLoginModal = function() {
            var modalInstance = $modal.open({
                templateUrl: '/partials/login.modal.html',
                controller: 'OAuth2LoginModalCtrl'
            });
            return modalInstance;
        };

        return oauth2Provider;
    });