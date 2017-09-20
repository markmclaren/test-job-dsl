job('delete_other_jobs') {
  steps {
    dsl {
      external('**/*.dsl')  
      removeAction('DELETE')      
    }
  }
}