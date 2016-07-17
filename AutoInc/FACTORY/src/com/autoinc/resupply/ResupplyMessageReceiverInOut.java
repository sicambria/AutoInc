
/**
 * ResupplyMessageReceiverInOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
        package com.autoinc.resupply;

        /**
        *  ResupplyMessageReceiverInOut message receiver
        */

        public class ResupplyMessageReceiverInOut extends org.apache.axis2.receivers.AbstractInOutMessageReceiver{


        public void invokeBusinessLogic(org.apache.axis2.context.MessageContext msgContext, org.apache.axis2.context.MessageContext newMsgContext)
        throws org.apache.axis2.AxisFault{

        try {

        // get the implementation class for the Web Service
        Object obj = getTheImplementationObject(msgContext);

        ResupplySkeletonInterface skel = (ResupplySkeletonInterface)obj;
        //Out Envelop
        org.apache.axiom.soap.SOAPEnvelope envelope = null;
        //Find the axisOperation that has been set by the Dispatch phase.
        org.apache.axis2.description.AxisOperation op = msgContext.getOperationContext().getAxisOperation();
        if (op == null) {
        throw new org.apache.axis2.AxisFault("Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
        }

        java.lang.String methodName;
        if((op.getName() != null) && ((methodName = org.apache.axis2.util.JavaUtils.xmlNameToJavaIdentifier(op.getName().getLocalPart())) != null)){


        

            if("cancelResupplyOperation".equals(methodName)){
                
                com.autoinc.resupply.CancelResupplyOperationResponse cancelResupplyOperationResponse5 = null;
	                        com.autoinc.resupply.CancelResupplyOperation wrappedParam =
                                                             (com.autoinc.resupply.CancelResupplyOperation)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    com.autoinc.resupply.CancelResupplyOperation.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               cancelResupplyOperationResponse5 =
                                                   
                                                   
                                                         skel.cancelResupplyOperation(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), cancelResupplyOperationResponse5, false, new javax.xml.namespace.QName("http://autoinc.com/Resupply/",
                                                    "cancelResupplyOperation"));
                                    } else 

            if("resupplyOperation".equals(methodName)){
                
                com.autoinc.resupply.ResupplyOperationResponse resupplyOperationResponse7 = null;
	                        com.autoinc.resupply.ResupplyOperation wrappedParam =
                                                             (com.autoinc.resupply.ResupplyOperation)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    com.autoinc.resupply.ResupplyOperation.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               resupplyOperationResponse7 =
                                                   
                                                   
                                                         skel.resupplyOperation(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), resupplyOperationResponse7, false, new javax.xml.namespace.QName("http://autoinc.com/Resupply/",
                                                    "resupplyOperation"));
                                    
            } else {
              throw new java.lang.RuntimeException("method not found");
            }
        

        newMsgContext.setEnvelope(envelope);
        }
        }
        catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
        }
        
        //
            private  org.apache.axiom.om.OMElement  toOM(com.autoinc.resupply.CancelResupplyOperation param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.autoinc.resupply.CancelResupplyOperation.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.autoinc.resupply.CancelResupplyOperationResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.autoinc.resupply.CancelResupplyOperationResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.autoinc.resupply.ResupplyOperation param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.autoinc.resupply.ResupplyOperation.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.autoinc.resupply.ResupplyOperationResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.autoinc.resupply.ResupplyOperationResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, com.autoinc.resupply.CancelResupplyOperationResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(com.autoinc.resupply.CancelResupplyOperationResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private com.autoinc.resupply.CancelResupplyOperationResponse wrapcancelResupplyOperation(){
                                com.autoinc.resupply.CancelResupplyOperationResponse wrappedElement = new com.autoinc.resupply.CancelResupplyOperationResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, com.autoinc.resupply.ResupplyOperationResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(com.autoinc.resupply.ResupplyOperationResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private com.autoinc.resupply.ResupplyOperationResponse wrapresupplyOperation(){
                                com.autoinc.resupply.ResupplyOperationResponse wrappedElement = new com.autoinc.resupply.ResupplyOperationResponse();
                                return wrappedElement;
                         }
                    


        /**
        *  get the default envelope
        */
        private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory){
        return factory.getDefaultEnvelope();
        }


        private  java.lang.Object fromOM(
        org.apache.axiom.om.OMElement param,
        java.lang.Class type,
        java.util.Map extraNamespaces) throws org.apache.axis2.AxisFault{

        try {
        
                if (com.autoinc.resupply.CancelResupplyOperation.class.equals(type)){
                
                           return com.autoinc.resupply.CancelResupplyOperation.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.autoinc.resupply.CancelResupplyOperationResponse.class.equals(type)){
                
                           return com.autoinc.resupply.CancelResupplyOperationResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.autoinc.resupply.ResupplyOperation.class.equals(type)){
                
                           return com.autoinc.resupply.ResupplyOperation.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.autoinc.resupply.ResupplyOperationResponse.class.equals(type)){
                
                           return com.autoinc.resupply.ResupplyOperationResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
        } catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
           return null;
        }



    

        /**
        *  A utility method that copies the namepaces from the SOAPEnvelope
        */
        private java.util.Map getEnvelopeNamespaces(org.apache.axiom.soap.SOAPEnvelope env){
        java.util.Map returnMap = new java.util.HashMap();
        java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();
        while (namespaceIterator.hasNext()) {
        org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator.next();
        returnMap.put(ns.getPrefix(),ns.getNamespaceURI());
        }
        return returnMap;
        }

        private org.apache.axis2.AxisFault createAxisFault(java.lang.Exception e) {
        org.apache.axis2.AxisFault f;
        Throwable cause = e.getCause();
        if (cause != null) {
            f = new org.apache.axis2.AxisFault(e.getMessage(), cause);
        } else {
            f = new org.apache.axis2.AxisFault(e.getMessage());
        }

        return f;
    }

        }//end of class
    