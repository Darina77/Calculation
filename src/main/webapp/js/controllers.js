'use strict';

var calculationApp = calculationApp || {};

calculationApp.controllers = angular.module('calculationControllers', ['ui.bootstrap']);


calculationApp.controllers.controller('loadCategories', function ($scope, $log, oauth2Provider, HTTP_ERRORS)
{
    $scope.recipes = [];
    $scope.getRecipesByType = function(type){
         $scope.enumType = $scope.convertType(type);
        $scope.loading = true;
                gapi.client.calculation.getRecipesByType($scope.enumType).
                    execute(function (resp) {
                        $scope.$apply(function () {
                            $scope.loading = false;
                            if (resp.error) {
                                // The request has failed.
                                var errorMessage = resp.error.message || '';
                                $scope.messages = 'Failed to query the recipes : ' + errorMessage;
                                $scope.alertStatus = 'warning';
                                $log.error($scope.messages);

                                if (resp.code && resp.code == HTTP_ERRORS.UNAUTHORIZED) {
                                    oauth2Provider.showLoginModal();
                                    return;
                                }
                            } else {
                                // The request has succeeded.
                                $scope.submitted = false;
                                $scope.messages = 'Query succeeded';
                                $scope.alertStatus = 'success';
                                $log.info($scope.messages);


                                angular.forEach(resp.items, function (recipe) {
                                    $scope.recipes.push(recipe);
                                });
                            }
                            $scope.submitted = true;
                        });
              });

              $scope.convertType = function(type)
              {
                for(var i = 0; i < 16; i++){
                    if($scope.allTypes[i].displayName == type)
                    {
                        $scope.enumType = $scope.allTypes[i].enumValue;
                    }

                  };
              }
    }

    $scope.allTypes = [ {enumValue: 'COLD', displayName: 'Холодні закуски'},
                            {enumValue: 'POULTY_RABBIT', displayName: 'Страви з сільсько-господарської птиці, пернатої дичі та кролика'},
                            {enumValue: 'SAUCES', displayName: 'Соуси'},
                            {enumValue: 'SOUPS', displayName: 'Супи'},
                            {enumValue: 'FISH_SEAFOOD', displayName: 'Страви з риби морепродуктів і раків'},
                            {enumValue: 'MEAT', displayName: "Страви з м'яса та м'ясних виробів"},
                            {enumValue: 'POTATOES_VEGETABLES_MUSHROOMS', displayName: 'Страви з картоплі овочів та грибів'},
                            {enumValue: 'SWEET', displayName: 'Солодкі страви'},
                            {enumValue: 'CURD', displayName: 'Страви з творогу'},
                            {enumValue: 'MACARONI', displayName: 'Страви з макаронних виробів'},
                            {enumValue: 'GARNISH', displayName: 'Гарніри'},
                            {enumValue: 'BEAN', displayName: 'Страви з бобових'},
                            {enumValue: 'CROUP', displayName: 'Страви з круп'},
                            {enumValue: 'FLOUR', displayName: 'Борошняні вироби'},
                            {enumValue: 'EGG', displayName: 'Страви з яєць'},
                            {enumValue: 'BEVERAGES', displayName: 'Напої'} ];
});




calculationApp.controllers.controller('loadCategories', function ($scope, $log, oauth2Provider, HTTP_ERRORS)
{
    /**
         *
         * @type {{displayName: string, enumValue: string}[]}
         */
    $scope.savedType = "";

    $scope.saveType = function(){
        $scope.savedType = $event.text();
    }
    $scope.allTypes = [ {enumValue: 'COLD', displayName: 'Холодні закуски'},
                        {enumValue: 'POULTY_RABBIT', displayName: 'Страви з сільсько-господарської птиці, пернатої дичі та кролика'},
                        {enumValue: 'SAUCES', displayName: 'Соуси'},
                        {enumValue: 'SOUPS', displayName: 'Супи'},
                        {enumValue: 'FISH_SEAFOOD', displayName: 'Страви з риби морепродуктів і раків'},
                        {enumValue: 'MEAT', displayName: "Страви з м'яса та м'ясних виробів"},
                        {enumValue: 'POTATOES_VEGETABLES_MUSHROOMS', displayName: 'Страви з картоплі овочів та грибів'},
                        {enumValue: 'SWEET', displayName: 'Солодкі страви'},
                        {enumValue: 'CURD', displayName: 'Страви з творогу'},
                        {enumValue: 'MACARONI', displayName: 'Страви з макаронних виробів'},
                        {enumValue: 'GARNISH', displayName: 'Гарніри'},
                        {enumValue: 'BEAN', displayName: 'Страви з бобових'},
                        {enumValue: 'CROUP', displayName: 'Страви з круп'},
                        {enumValue: 'FLOUR', displayName: 'Борошняні вироби'},
                        {enumValue: 'EGG', displayName: 'Страви з яєць'},
                        {enumValue: 'BEVERAGES', displayName: 'Напої'} ];
    $scope.contents = [{"picture": "/img/0.jpeg", "name" : $scope.allTypes[0].displayName, "id" : 0}];
    for(var i = 1; i < 16; i++){
        $scope.contents.push({"picture" : "/img/"+i+".jpeg", "name" : $scope.allTypes[i].displayName, "id": i});
    };

});

