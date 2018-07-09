# android-mvvm

Model : Data and Business logic resides.

View Model : Interact with model and notify the View over observer.
             doesnot hold reference of view. Expose stream of data.
             
View  : Observer the View Model class data. UI logic
        View has reference of ViewModel. 
        
        There is one to many  relationship between View and viewmodel.