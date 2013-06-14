angular.module('webshop', ['components', 'webshop.filters']).
  config(['$routeProvider', function($routeProvider) {
  $routeProvider.
  	  when('/products', {templateUrl: 'partials/products.html',   controller: ProductsCtrl}).      
      otherwise({redirectTo: '/products'});
}])

angular.module('components', [])
	.directive('navbar', function() {
		return {
			restrict: 'E',
			controller: 'CategoriesCtrl',
			templateUrl: 'partials/navbar.html'
		}
	}
);
