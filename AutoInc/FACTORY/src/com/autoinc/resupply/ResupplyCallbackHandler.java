
/**
 * ResupplyCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package com.autoinc.resupply;

    /**
     *  ResupplyCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class ResupplyCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public ResupplyCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public ResupplyCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for cancelResupplyOperation method
            * override this method for handling normal response from cancelResupplyOperation operation
            */
           public void receiveResultcancelResupplyOperation(
                    com.autoinc.resupply.CancelResupplyOperationResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from cancelResupplyOperation operation
           */
            public void receiveErrorcancelResupplyOperation(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for resupplyOperation method
            * override this method for handling normal response from resupplyOperation operation
            */
           public void receiveResultresupplyOperation(
                    com.autoinc.resupply.ResupplyOperationResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from resupplyOperation operation
           */
            public void receiveErrorresupplyOperation(java.lang.Exception e) {
            }
                


    }
    