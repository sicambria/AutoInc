
/**
 * RegionalSalesWSDLFileCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package com.autoinc.auto_regional;

    /**
     *  RegionalSalesWSDLFileCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class RegionalSalesWSDLFileCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public RegionalSalesWSDLFileCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public RegionalSalesWSDLFileCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for receiveCarsFromManufacture method
            * override this method for handling normal response from receiveCarsFromManufacture operation
            */
           public void receiveResultreceiveCarsFromManufacture(
                    com.autoinc.auto_regional.RegionalSalesWSDLFileStub.ReceiveCarsFromManufactureResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from receiveCarsFromManufacture operation
           */
            public void receiveErrorreceiveCarsFromManufacture(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for cancelOrder method
            * override this method for handling normal response from cancelOrder operation
            */
           public void receiveResultcancelOrder(
                    com.autoinc.auto_regional.RegionalSalesWSDLFileStub.CancelOrderResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from cancelOrder operation
           */
            public void receiveErrorcancelOrder(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for receiveOrder method
            * override this method for handling normal response from receiveOrder operation
            */
           public void receiveResultreceiveOrder(
                    com.autoinc.auto_regional.RegionalSalesWSDLFileStub.ReceiveOrderResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from receiveOrder operation
           */
            public void receiveErrorreceiveOrder(java.lang.Exception e) {
            }
                


    }
    