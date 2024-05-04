package com.wwpbaseobjects ;
import com.genexus.*;

public final  class StructSdtWizardSteps_WizardStepsItem implements Cloneable, java.io.Serializable
{
   public StructSdtWizardSteps_WizardStepsItem( )
   {
      this( -1, new ModelContext( StructSdtWizardSteps_WizardStepsItem.class ));
   }

   public StructSdtWizardSteps_WizardStepsItem( int remoteHandle ,
                                                ModelContext context )
   {
      gxTv_SdtWizardSteps_WizardStepsItem_Code = "" ;
      gxTv_SdtWizardSteps_WizardStepsItem_Title = "" ;
      gxTv_SdtWizardSteps_WizardStepsItem_Description = "" ;
   }

   public Object clone()
   {
      Object cloned = null;
      try
      {
         cloned = super.clone();
      }catch (CloneNotSupportedException e){ ; }
      return cloned;
   }

   public String getCode( )
   {
      return gxTv_SdtWizardSteps_WizardStepsItem_Code ;
   }

   public void setCode( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWizardSteps_WizardStepsItem_Code = value ;
   }

   public String getTitle( )
   {
      return gxTv_SdtWizardSteps_WizardStepsItem_Title ;
   }

   public void setTitle( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWizardSteps_WizardStepsItem_Title = value ;
   }

   public String getDescription( )
   {
      return gxTv_SdtWizardSteps_WizardStepsItem_Description ;
   }

   public void setDescription( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWizardSteps_WizardStepsItem_Description = value ;
   }

   protected byte sdtIsNull ;
   protected String gxTv_SdtWizardSteps_WizardStepsItem_Code ;
   protected String gxTv_SdtWizardSteps_WizardStepsItem_Title ;
   protected String gxTv_SdtWizardSteps_WizardStepsItem_Description ;
}

