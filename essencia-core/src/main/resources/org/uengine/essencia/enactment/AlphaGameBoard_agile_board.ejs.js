/**
 * Created by uengine on 2017. 3. 24..
 */

var org_uengine_essencia_enactment_AlphaGameBoard_agile_board = function(objectId, className){



}

org_uengine_essencia_enactment_AlphaGameBoard_agile_board.prototype = {
  'addAlphaInstance': function(object, autowiredObjects){
      var alpha = object.alpha;

      var newAlphaInstance = {
          __className: 'org.uengine.essencia.enactment.AlphaInstance',
          alpha: alpha,
            id: 'New ' + alpha.name
      }
      LanguageElementInstance alphaInstance = alpha.createObjectInstance();
      alphaInstance.setBeanProperty("Id", "New " + alpha.getName());
      alphaInstance.setId("New " + alpha.getName());

      ProcessManagerRemote processManagerRemote = MetaworksRemoteService.getComponent(ProcessManagerRemote.class);

      ProcessInstance instance = processManagerRemote.getProcessInstance(getInstanceId());

      ProcessVariableValue processVariableValue = instance.getMultiple("", alpha.getName());

      if(processVariableValue==null){
          processVariableValue = new ProcessVariableValue();
          processVariableValue.setName(alpha.getName());
      }
      processVariableValue.moveToAdd();
      processVariableValue.setValue(alphaInstance);

      instance.set("",  processVariableValue);

      processManagerRemote.applyChanges();


      EssenceProcessDefinition essenceProcessDefinition = (EssenceProcessDefinition) instance.getProcessDefinition();
      PracticeDefinition practiceDefinition = essenceProcessDefinition.getPracticeDefinition();
      GameBoard gameBoard = new GameBoard(instance, true);

      AlphaGameBoard alphaGameBoard = new AlphaGameBoard(getInstanceId(), (Alpha) practiceDefinition.getElementByName(alpha.getName()), gameBoard.getAlphaInstancesMap());
      alphaGameBoard.getMetaworksContext().setWhen(MetaworksContext.WHEN_EDIT);

      //MetaworksRemoteService.wrapReturn(alphaGameBoard);

      return alphaGameBoard;

  }

};