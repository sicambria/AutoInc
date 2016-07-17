
/**
 * OrderTransportMessageReceiverInOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
        package com.transportinc.ordertransport;

        /**
        *  OrderTransportMessageReceiverInOut message receiver
        */

        public class OrderTransportMessageReceiverInOut extends org.apache.axis2.receivers.AbstractInOutMessageReceiver{


        public void invokeBusinessLogic(org.apache.axis2.context.MessageContext msgContext, org.apache.axis2.context.MessageContext newMsgContext)
        throws org.apache.axis2.AxisFault{

        try {

        // get the implementation class for the Web Service
        Object obj = getTheImplementationObject(msgContext);

        OrderTransportSkeletonInterface skel = (OrderTransportSkeletonInterface)obj;
        //Out Envelop
        org.apache.axiom.soap.SOAPEnvelope envelope = null;
        //Find the axisOperation that has been set by the Dispatch phase.
        org.apache.axis2.description.AxisOperation op = msgContext.getOperationContext().getAxisOperation();
        if (op == null) {
        throw new org.apache.axis2.AxisFault("Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
        }

        java.lang.String methodName;
        if((op.getName() != null) && ((methodName = org.apache.axis2.util.JavaUtils.xmlNameToJavaIdentifier(op.getName().getLocalPart())) != null)){


        

            if("cancelOrderTransport".equals(methodName)){
                
                com.transportinc.ordertransport.CancelOrderTransportResponse cancelOrderTransportResponse5 = null;
	                        com.transportinc.ordertransport.CancelOrderTransport wrappedParam =
                                                             (com.transportinc.ordertransport.CancelOrderTransport)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    com.transportinc.ordertransport.CancelOrderTransport.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               cancelOrderTransportResponse5 =
                                                   
                                                   
                                                         skel.cancelOrderTransport(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), cancelOrderTransportResponse5, false, new javax.xml.namespace.QName("http://transportinc.com/orderTransport/",
                                                    "cancelOrderTransport"));
                                    } else 

            if("orderTransport".equals(methodName)){
                
                com.transportinc.ordertransport.OrderTransportResponse orderTransportResponse7 = null;
	                        com.transportinc.ordertransport.OrderTransport wrappedParam =
                                                             (com.transportinc.ordertransport.OrderTransport)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    com.transportinc.ordertransport.OrderTransport.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               orderTransportResponse7 =
                                                   
                                                   
                                                         skel.orderTransport(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), orderTransportResponse7, false, new javax.xml.namespace.QName("http://transportinc.com/orderTransport/",
                                                    "orderTransport"));
                                    
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
            private  org.apache.axiom.om.OMElement  toOM(com.transportinc.ordertransport.CancelOrderTransport param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.transportinc.ordertransport.CancelOrderTransport.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.transportinc.ordertransport.CancelOrderTransportResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.transportinc.ordertransport.CancelOrderTransportResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.transportinc.ordertransport.OrderTransport param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.transportinc.ordertransport.OrderTransport.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.transportinc.ordertransport.OrderTransportResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.transportinc.ordertransport.OrderTransportResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, com.transportinc.ordertransport.CancelOrderTransportResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(com.transportinc.ordertransport.CancelOrderTransportResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private com.transportinc.ordertransport.CancelOrderTransportResponse wrapcancelOrderTransport(){
                                com.transportinc.ordertransport.CancelOrderTransportResponse wrappedElement = new com.transportinc.ordertransport.CancelOrderTransportResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, com.transportinc.ordertransport.OrderTransportResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(com.transportinc.ordertransport.OrderTransportResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private com.transportinc.ordertransport.OrderTransportResponse wrapOrderTransport(){
                                com.transportinc.ordertransport.OrderTransportResponse wrappedElement = new com.transportinc.ordertransport.OrderTransportResponse();
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
        
                if (com.transportinc.ordertransport.CancelOrderTransport.class.equals(type)){
                
                           return com.transportinc.ordertransport.CancelOrderTransport.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.transportinc.ordertransport.CancelOrderTransportResponse.class.equals(type)){
                
                           return com.transportinc.ordertransport.CancelOrderTransportResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.transportinc.ordertransport.OrderTransport.class.equals(type)){
                
                           return com.transportinc.ordertransport.OrderTransport.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.transportinc.ordertransport.OrderTransportResponse.class.equals(type)){
                
                           return com.transportinc.ordertransport.OrderTransportResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

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
    