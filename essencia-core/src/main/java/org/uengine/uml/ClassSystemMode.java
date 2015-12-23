package org.uengine.uml;

/**
 * Created by jjy on 2015. 12. 22..
 */
public class ClassSystemMode {

    static ThreadLocal<ClassSystemMode> threadLocal = new ThreadLocal<ClassSystemMode>();

    public static ClassSystemMode getThreadLocalInstance(){
        ClassSystemMode csm = threadLocal.get();

		if(csm==null){
			csm = new ClassSystemMode();
            threadLocal.set(csm);
		}

        return csm;

    }

    boolean isDesignTime;
        public boolean isDesignTime() {
            return isDesignTime;
        }
        public void setDesignTime(boolean isDesignTime) {
            this.isDesignTime = isDesignTime;
        }

}
