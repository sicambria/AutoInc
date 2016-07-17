
/**
 * InventoryWSDLFileMessageReceiverInOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
        package com.autoinc.www.inventorywsdlfile;

        /**
        *  InventoryWSDLFileMessageReceiverInOut message receiver
        */

        public class InventoryWSDLFileMessageReceiverInOut extends org.apache.axis2.receivers.AbstractInOutMessageReceiver{


        public void invokeBusinessLogic(org.apache.axis2.context.MessageContext msgContext, org.apache.axis2.context.MessageContext newMsgContext)
        throws org.apache.axis2.AxisFault{

        try {

        // get the implementation class for the Web Service
        Object obj = getTheImplementationObject(msgContext);

        InventoryWSDLFileSkeletonInterface skel = (InventoryWSDLFileSkeletonInterface)obj;
        //Out Envelop
        org.apache.axiom.soap.SOAPEnvelope envelope = null;
        //Find the axisOperation that has been set by the Dispatch phase.
        org.apache.axis2.description.AxisOperation op = msgContext.getOperationContext().getAxisOperation();
        if (op == null) {
        throw new org.apache.axis2.AxisFault("Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
        }

        java.lang.String methodName;
        if((op.getName() != null) && ((methodName = org.apache.axis2.util.JavaUtils.xmlNameToJavaIdentifier(op.getName().getLocalPart())) != null)){


        

            if("addParts".equals(methodName)){
                
                com.autoinc.www.inventorywsdlfile.AddPartsResponse addPartsResponse25 = null;
	                        com.autoinc.www.inventorywsdlfile.AddParts wrappedParam =
                                                             (com.autoinc.www.inventorywsdlfile.AddParts)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    com.autoinc.www.inventorywsdlfile.AddParts.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               addPartsResponse25 =
                                                   
                                                   
                                                         skel.addParts(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), addPartsResponse25, false, new javax.xml.namespace.QName("http://www.autoinc.com/InventoryWSDLFile/",
                                                    "addParts"));
                                    } else 

            if("supplyParts".equals(methodName)){
                
                com.autoinc.www.inventorywsdlfile.SupplyPartsResponse supplyPartsResponse27 = null;
	                        com.autoinc.www.inventorywsdlfile.SupplyParts wrappedParam =
                                                             (com.autoinc.www.inventorywsdlfile.SupplyParts)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    com.autoinc.www.inventorywsdlfile.SupplyParts.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               supplyPartsResponse27 =
                                                   
                                                   
                                                         skel.supplyParts(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), supplyPartsResponse27, false, new javax.xml.namespace.QName("http://www.autoinc.com/InventoryWSDLFile/",
                                                    "supplyParts"));
                                    } else 

            if("updateParts".equals(methodName)){
                
                com.autoinc.www.inventorywsdlfile.UpdatePartsResponse updatePartsResponse29 = null;
	                        com.autoinc.www.inventorywsdlfile.UpdateParts wrappedParam =
                                                             (com.autoinc.www.inventorywsdlfile.UpdateParts)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    com.autoinc.www.inventorywsdlfile.UpdateParts.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               updatePartsResponse29 =
                                                   
                                                   
                                                         skel.updateParts(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), updatePartsResponse29, false, new javax.xml.namespace.QName("http://www.autoinc.com/InventoryWSDLFile/",
                                                    "updateParts"));
                                    } else 

            if("getParts".equals(methodName)){
                
                com.autoinc.www.inventorywsdlfile.GetPartsResponse getPartsResponse31 = null;
	                        com.autoinc.www.inventorywsdlfile.GetParts wrappedParam =
                                                             (com.autoinc.www.inventorywsdlfile.GetParts)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    com.autoinc.www.inventorywsdlfile.GetParts.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getPartsResponse31 =
                                                   
                                                   
                                                         skel.getParts(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getPartsResponse31, false, new javax.xml.namespace.QName("http://www.autoinc.com/InventoryWSDLFile/",
                                                    "getParts"));
                                    
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
            private  org.apache.axiom.om.OMElement  toOM(com.autoinc.www.inventorywsdlfile.AddParts param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.autoinc.www.inventorywsdlfile.AddParts.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.autoinc.www.inventorywsdlfile.AddPartsResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.autoinc.www.inventorywsdlfile.AddPartsResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.autoinc.www.inventorywsdlfile.SupplyParts param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.autoinc.www.inventorywsdlfile.SupplyParts.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.autoinc.www.inventorywsdlfile.SupplyPartsResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.autoinc.www.inventorywsdlfile.SupplyPartsResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.autoinc.www.inventorywsdlfile.UpdateParts param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.autoinc.www.inventorywsdlfile.UpdateParts.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.autoinc.www.inventorywsdlfile.UpdatePartsResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.autoinc.www.inventorywsdlfile.UpdatePartsResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.autoinc.www.inventorywsdlfile.GetParts param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.autoinc.www.inventorywsdlfile.GetParts.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.autoinc.www.inventorywsdlfile.GetPartsResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.autoinc.www.inventorywsdlfile.GetPartsResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, com.autoinc.www.inventorywsdlfile.AddPartsResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(com.autoinc.www.inventorywsdlfile.AddPartsResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private com.autoinc.www.inventorywsdlfile.AddPartsResponse wrapaddParts(){
                                com.autoinc.www.inventorywsdlfile.AddPartsResponse wrappedElement = new com.autoinc.www.inventorywsdlfile.AddPartsResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, com.autoinc.www.inventorywsdlfile.SupplyPartsResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(com.autoinc.www.inventorywsdlfile.SupplyPartsResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private com.autoinc.www.inventorywsdlfile.SupplyPartsResponse wrapsupplyParts(){
                                com.autoinc.www.inventorywsdlfile.SupplyPartsResponse wrappedElement = new com.autoinc.www.inventorywsdlfile.SupplyPartsResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, com.autoinc.www.inventorywsdlfile.UpdatePartsResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(com.autoinc.www.inventorywsdlfile.UpdatePartsResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private com.autoinc.www.inventorywsdlfile.UpdatePartsResponse wrapupdateParts(){
                                com.autoinc.www.inventorywsdlfile.UpdatePartsResponse wrappedElement = new com.autoinc.www.inventorywsdlfile.UpdatePartsResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, com.autoinc.www.inventorywsdlfile.GetPartsResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(com.autoinc.www.inventorywsdlfile.GetPartsResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private com.autoinc.www.inventorywsdlfile.GetPartsResponse wrapgetParts(){
                                com.autoinc.www.inventorywsdlfile.GetPartsResponse wrappedElement = new com.autoinc.www.inventorywsdlfile.GetPartsResponse();
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
        
                if (com.autoinc.www.inventorywsdlfile.AddParts.class.equals(type)){
                
                           return com.autoinc.www.inventorywsdlfile.AddParts.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.autoinc.www.inventorywsdlfile.AddPartsResponse.class.equals(type)){
                
                           return com.autoinc.www.inventorywsdlfile.AddPartsResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.autoinc.www.inventorywsdlfile.SupplyParts.class.equals(type)){
                
                           return com.autoinc.www.inventorywsdlfile.SupplyParts.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.autoinc.www.inventorywsdlfile.SupplyPartsResponse.class.equals(type)){
                
                           return com.autoinc.www.inventorywsdlfile.SupplyPartsResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.autoinc.www.inventorywsdlfile.UpdateParts.class.equals(type)){
                
                           return com.autoinc.www.inventorywsdlfile.UpdateParts.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.autoinc.www.inventorywsdlfile.UpdatePartsResponse.class.equals(type)){
                
                           return com.autoinc.www.inventorywsdlfile.UpdatePartsResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.autoinc.www.inventorywsdlfile.GetParts.class.equals(type)){
                
                           return com.autoinc.www.inventorywsdlfile.GetParts.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.autoinc.www.inventorywsdlfile.GetPartsResponse.class.equals(type)){
                
                           return com.autoinc.www.inventorywsdlfile.GetPartsResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

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
    