package com.tutu.projectjsp.system.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tutu.projectjsp.base.dao.BasicHibernateDao;
import com.tutu.projectjsp.system.model.SysMenu;
import com.tutu.projectjsp.system.model.SysMenumx;
import com.tutu.projectjsp.system.model.SysModule;
import com.tutu.projectjsp.system.model.SysSystem;

@Repository
public class SysSystemDao extends BasicHibernateDao {

    @Override
    public Class getTheEntityClass() {
        return this.getClass();
    }
    
    public SysSystem getSysSystem(String syscode) {
        StringBuilder hql = new StringBuilder("from SysSystem where syscode=? ");        
        return (SysSystem) this.queryUniqueHql(hql.toString(), syscode);
    }
    
    public List<SysModule> getSysModuleList(String syscode) {
        StringBuilder hql = new StringBuilder("from SysModule where syscode=? order by orderno ");        
        return this.queryListHql(hql.toString(), syscode);
    }
    
    public List<SysMenu> getSysMenuList(String syscode, String mdcode) {
        StringBuilder hql = new StringBuilder("from SysMenu where syscode=? and mdcode=? order by orderno ");        
        return this.queryListHql(hql.toString(), syscode, mdcode);
    }
    
    public List<SysMenumx> getSysMenumxList(String syscode) {
        StringBuilder hql = new StringBuilder("from SysMenumx where syscode=? order by contorller ");        
        return this.queryListHql(hql.toString(), syscode);
    }
    
    public List<SysMenumx> getSysMenumxList(String mncode, String syscode) {
        StringBuilder hql = new StringBuilder("from SysMenumx where mncode=? and syscode=? ");        
        return this.queryListHql(hql.toString(), mncode, syscode);
    }

}
