export default class FormController {
    
        constructor($stateParams, $state, EstabeleciemntoServico) {
            this.record = {};
            this.title = 'Adicionando registro';
            this._service = EstabeleciemntoServico
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
                    this._state.go('estabelecimento.list')
                })
        }
    }
    
    FormController.$inject = ['$stateParams', '$state', 'EstabeleciemntoServico']