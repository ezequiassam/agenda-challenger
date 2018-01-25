angular.module('agenda', []).controller('portalController',
		function($scope, $http) {

			var _apiHost = 'localhost:8080/agenda';
//			$http.get('http://' + _apiHost).then(function(response) {
//				$scope.allAgenda = response.data;
//			});
			
			$scope.findAll = function() {
				$http.get('http://' + _apiHost).then(function(response) {
					$scope.allAgenda = response.data;
				});
			}
			
			$scope.findById =  function findById(id) {
				 $http.get(_apiHost + '/'+ id).then(function(response) {
				 return response.data;
				 });
			}
			
		});

// angular.module('agenda').factory('portalService', ['$http', function ($http)
// {
//	
// var _apiHost = 'http://localhost:8080/agenda';
//	
// return {
//		
// findAll: function() {
// $http.get(_apiHost).then(function(response) {
// return response.data;
// });
// }
//				
// findById: function(id) {
// $http.delete(_apiHost + '/'+ id).then(function(response) {
// return response.data;
// });
// }

// createAgenda: function(params) {
// $http.post(_apiHost, params).then(function(response) {
// return response.data;
// });
// }
//		
// updateAgenda: function(id, params) {
// $http.put(_apiHost + '/' + id, params).then(function(response) {
// return response.data;
// });
// }
//		
// deleteAgenda: function(id) {
// $http.delete(_apiHost + '/'+ id).then(function(response) {
// return response.data;
// });
// }
// }

// }]);
