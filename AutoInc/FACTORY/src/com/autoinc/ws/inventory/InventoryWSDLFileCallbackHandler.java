
/**
 * InventoryWSDLFileCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package com.autoinc.ws.inventory;

    /**
     *  InventoryWSDLFileCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class InventoryWSDLFileCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public InventoryWSDLFileCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public InventoryWSDLFileCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for updateParts method
            * override this method for handling normal response from updateParts operation
            */
           public void receiveResultupdateParts(
                    com.autoinc.ws.inventory.InventoryWSDLFileStub.UpdatePartsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from updateParts operation
           */
            public void receiveErrorupdateParts(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addParts method
            * override this method for handling normal response from addParts operation
            */
           public void receiveResultaddParts(
                    com.autoinc.ws.inventory.InventoryWSDLFileStub.AddPartsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addParts operation
           */
            public void receiveErroraddParts(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for supplyParts method
            * override this method for handling normal response from supplyParts operation
            */
           public void receiveResultsupplyParts(
                    com.autoinc.ws.inventory.InventoryWSDLFileStub.SupplyPartsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from supplyParts operation
           */
            public void receiveErrorsupplyParts(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getParts method
            * override this method for handling normal response from getParts operation
            */
           public void receiveResultgetParts(
                    com.autoinc.ws.inventory.InventoryWSDLFileStub.GetPartsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getParts operation
           */
            public void receiveErrorgetParts(java.lang.Exception e) {
            }
                


    }
    