export default class FormController {
    
        constructor($stateParams, $state, MonstraoServico) {
            this.record = {};
            this.title = 'Adicionando registro';
            this._service = MonstraoServico
            if ($stateParams.id) {
                this.title = 'Editando registro';
                this._service.findById($stateParams.id)
                   .then(data => {
                       this.record = data
                   })
            }
            this._state = $state;
        }
    
        save() {
            this._service.save(this.record)
                .then(resp => {
                    this._state.go('monstrao.list')
                })
        }
    }
    
    FormController.$inject = ['$stateParams', '$state', 'MonstraoServico']