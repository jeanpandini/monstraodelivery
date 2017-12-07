import ListController from './list.controller'
import FormController from './form.controller'

import MonstraoServico from './servico'

export const monstraoConfig = (modulo) => {

  modulo.service('MonstraoServico', MonstraoServico)
  
  return ['$stateProvider', '$urlRouterProvider', 
   ($stateProvider, $urlRouterProvider) => {
    $stateProvider
      .state('monstrao', {
        template: require('@views/default.html'),
        url: '/monstrao',
        onEnter: ['$state', function($state) {
          $state.go('monstrao.list')
        }]
      })
      .state('monstrao.list', {
        template: require('@views/monstrao/list.html'),
        url: '/list',
        controller: ListController,
        controllerAs: 'vm'
      })
      .state('monstrao.new', {
        template: require('@views/monstrao/form.html'),
        url: '/new',
        controller: FormController,
        controllerAs: 'vm'
      })
      .state('monstrao.edit', {
        template: require('@views/monstrao/form.html'),
        url: '/{id}',
        controller: FormController,
        controllerAs: 'vm'
      });
  }]
}