package org.uengine.essencia.util;

import org.uengine.essencia.model.*;
import org.uengine.essencia.model.view.KernelLanguageViewable;
import org.uengine.essencia.modeling.EssenciaKernelSymbol;
import org.uengine.modeling.ElementView;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ik on 2015-06-24.
 */
public final class KernelUtil {
    private static KernelUtil instance;

    private PracticeDefinition practiceDefinition;

    private KernelUtil() {
        this.practiceDefinition = new PracticeDefinition();
        practiceDefinition.getElementList().addAll(createKernelAlphas());
        practiceDefinition.getElementList().addAll(createKernelActivitySpaces());
        practiceDefinition.getElementList().addAll(createKernelCompetencies());
    }

    public static KernelUtil getInstance() {
        if (instance == null) {
            synchronized (KernelUtil.class) {
                if (instance == null) {
                    instance = new KernelUtil();
                }
            }
        }
        return instance;
    }

    public PracticeDefinition getPracticeDefinition() {
        PracticeDefinition returnDefinition = null;
        try {
            returnDefinition = (PracticeDefinition) deepCopy(this.practiceDefinition);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnDefinition;
    }

    public List<Alpha> getKernelAlphaList() {
        List<Alpha> returnArr = null;
        try {
            returnArr = (List<Alpha>) deepCopy(this.practiceDefinition.getElements(Alpha.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnArr;
    }

    private Object deepCopy(Object source) throws Exception {
        Object returnDefinition = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(source);
            oos.flush();
            ByteArrayInputStream bin = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bin);
            returnDefinition = ois.readObject();
        } catch (Exception e) {
            System.err.println("Exception in ObjectCloner = " + e);
            throw (e);
        } finally {
            oos.close();
            ois.close();
        }

        return returnDefinition;
    }

    private List<Alpha> createKernelAlphas() {
        List<Alpha> alphas = new ArrayList<>();
        String alphasString = "Stakeholders\n" +
                "Customer\n" +
                "The people,groups,or organizations who affect or are affected by a software system. \n" +
                "The stakeholders provide the opportunity,and are the source of the requirements for the software system. They are involved throughout the software engineering endeavor to support the team and ensure that an acceptable software system is produced.\n" +
                "\n" +
                "Recognized\n" +
                "Stakeholders have been identified.\n" +
                "All the different groups of stakeholders that are,or will be,affected by the development and operation of the software system are identified.\n" +
                "There is agreement on the stakeholder groups to be represented. At a minimum,the stakeholder groups that fund,use,support,and maintain the system have been considered.\n" +
                "The responsibilities of the stakeholder representatives have been defined.\n" +
                "\n" +
                "Represented\n" +
                "The mechanisms for involving the stakeholders are agreed and the stakeholder representatives have been appointed.\n" +
                "The stakeholder representatives have agreed to take on their responsibilities.\n" +
                "The stakeholder representatives are authorized to carry out their responsibilities.\n" +
                "The collaboration approach among the stakeholder representatives has been agreed.\n" +
                "The stakeholder representatives support and respect the team's way of working.\n" +
                "\n" +
                "Involved\n" +
                "The stakeholder representatives are actively involved in the work and fulfilling their responsibilities.\n" +
                "The stakeholder representatives assist the team in accordance with their responsibilities.\n" +
                "The stakeholder representatives provide feedback and take part in decision making in a timely manner.\n" +
                "The stakeholder representatives promptly communicate changes that are relevant for their stakeholder groups.\n" +
                "\n" +
                "In Agreement\n" +
                "The stakeholder representatives are in agreement.\n" +
                "The stakeholder representatives have agreed upon their minimal expectations for the next deployment of the new system.\n" +
                "The stakeholder representatives are happy with their involvement in the work.\n" +
                "The stakeholder representatives agree that their input is valued by the team and treated with respect.\n" +
                "The team members agree that their input is valued by the stakeholder representatives and treated with respect.\n" +
                "The stakeholder representatives agree with how their different priorities and perspectives are being balanced to provide a clear direction for the team.\n" +
                "\n" +
                "Satisfied for Deployment\n" +
                "The minimal expectations of the stakeholder representatives have been achieved.\n" +
                "The stakeholder representatives provide feedback on the system from their stakeholder group perspective.\n" +
                "The stakeholder representatives confirm that they agree that the system is ready for deployment.\n" +
                "\n" +
                "Satisfied in Use\n" +
                "The system has met or exceeds the minimal stakeholder expectations.\n" +
                "Stakeholders are using the new system and providing feedback on their experiences.\n" +
                "The stakeholders confirm that the new system meets their expectations.\n" +
                "@\n" +
                "Opportunity\n" +
                "Customer\n" +
                "The set of circumstances that makes it appropriate to develop or change a software system.\n" +
                "The opportunity articulates the reason for the creation of the new,or changed,software system. It represents the team’s shared understanding of the stakeholders' needs,and helps shape the requirements for the new software system by providing justification for its development.\n" +
                "\n" +
                "Identified\n" +
                "A commercial,social,or business opportunity has been identified that could be addressed by a software-based solution.\n" +
                "An idea for a way of improving current ways of working,increasing market share,or applying a new or innovative software system has been identified.\n" +
                "At least one of the stakeholders wishes to make an investment in better understanding the opportunity and the value associated with addressing it.\n" +
                "The other stakeholders who share the opportunity have been identified.\n" +
                "\n" +
                "Solution Needed\n" +
                "The need for a software-based solution has been confirmed.\n" +
                "The stakeholders in the opportunity and the proposed solution have been identified.\n" +
                "The stakeholders’ needs that generate the opportunity have been established.\n" +
                "Any underlying problems and their root causes have been identified.\n" +
                "It has been confirmed that a software-based solution is needed.\n" +
                "At least one software-based solution has been proposed.\n" +
                "\n" +
                "Value Established\n" +
                "The value of a successful solution has been established.\n" +
                "The value of addressing the opportunity has been quantified either in absolute terms or in returns or savings per time period (e.g.,per annum).\n" +
                "The impact of the solution on the stakeholders is understood.\n" +
                "The value that the software system offers to the stakeholders that fund and use the software system is understood.\n" +
                "The success criteria by which the deployment of the software system is to be judged are clear.\n" +
                "The desired outcomes required of the solution are clear and quantified.\n" +
                "\n" +
                "Viable \n" +
                "It is agreed that a solution can be produced quickly and cheaply enough to successfully address the opportunity.\n" +
                "A solution has been outlined.\n" +
                "The indications are that the solution can be developed and deployed within constraints.\n" +
                "The risks associated with the solution are acceptable and manageable.\n" +
                "The indicative (ball-park) costs of the solution are less than the anticipated value of the opportunity.\n" +
                "The reasons for the development of a software-based solution are understood by all members of the team.\n" +
                "It is clear that the pursuit of the opportunity is viable.\n" +
                "\n" +
                "Addressed \n" +
                "A solution has been produced that demonstrably addresses the opportunity.\n" +
                "A usable system that demonstrably addresses the opportunity is available.\n" +
                "The stakeholders agree that the available solution is worth deploying.\n" +
                "The stakeholders are satisfied that the solution produced addresses the opportunity.\n" +
                "\n" +
                "Benefit Accrued \n" +
                "The operational use or sale of the solution is creating tangible benefits.\n" +
                "The solution has started to accrue benefits for the stakeholders.\n" +
                "The return-on-investment profile is at least as good as anticipated.\n" +
                "@\n" +
                "Requirements\n" +
                "Solution\n" +
                "What the software system must do to address the opportunity and satisfy the stakeholders.\n" +
                "It is important to discover what is needed from the software system,share this understanding among the stakeholders and the team members,and use it to drive the development and testing of the new system.\n" +
                "\n" +
                "Conceived\n" +
                "The need for a new system has been agreed.\n" +
                "The initial set of stakeholders agrees that a system is to be produced.\n" +
                "The stakeholders that will use the new system are identified.\n" +
                "The stakeholders that will fund the initial work on the new system are identified.\n" +
                "There is a clear opportunity for the new system to address.\n" +
                "\n" +
                "Bounded\n" +
                "The purpose and extent of the new system are clear.\n" +
                "The stakeholders involved in developing the new system are identified.\n" +
                "The stakeholders agree on the purpose of the new system.\n" +
                "It is clear what success is for the new system.\n" +
                "The stakeholders have a shared understanding of the extent of the proposed solution.\n" +
                "The way the requirements will be described is agreed upon.\n" +
                "The mechanisms for managing the requirements are in place.\n" +
                "The prioritization scheme is clear.\n" +
                "Constraints are identified and considered.\n" +
                "Assumptions are clearly stated.\n" +
                "\n" +
                "Coherent\n" +
                "The requirements provide a consistent description of the essential characteristics of the new system.\n" +
                "The requirements are captured and shared with the team and the stakeholders.\n" +
                "The origin of the requirements is clear.\n" +
                "The rationale behind the requirements is clear.\n" +
                "Conflicting requirements are identified and attended to.\n" +
                "The requirements communicate the essential characteristics of the system to be delivered.\n" +
                "The most important usage scenarios for the system can be explained.\n" +
                "The priority of the requirements is clear.\n" +
                "The impact of implementing the requirements is understood.\n" +
                "The team understands what has to be delivered and agrees to deliver it.\n" +
                "\n" +
                "Acceptable\n" +
                "The requirements describe a system that is acceptable to the stakeholders.\n" +
                "The stakeholders accept that the requirements describe an acceptable solution.\n" +
                "The rate of change to the agreed requirements is relatively low and under control.\n" +
                "The value provided by implementing the requirements is clear.\n" +
                "The parts of the opportunity satisfied by the requirements are clear.\n" +
                "The requirements are testable.\n" +
                "\n" +
                "Addressed\n" +
                "Enough of the requirements have been addressed to satisfy the need for a new system in a way that is acceptable to the stakeholders.\n" +
                "Enough of the requirements are addressed for the resulting system to be acceptable to the stakeholders.\n" +
                "The stakeholders accept the requirements as accurately reflecting what the system does and does not do.\n" +
                "The set of requirement items implemented provide clear value to the stakeholders.\n" +
                "The system implementing the requirements is accepted by the stakeholders as worth making operational.\n" +
                "\n" +
                "Fulfilled\n" +
                "The requirements that have been addressed fully satisfy the need for a new system.\n" +
                "The stakeholders accept the requirements as accurately capturing what they require to fully satisfy the need for a new system.\n" +
                "There are no outstanding requirement items preventing the system from being accepted as fully satisfying the requirements.\n" +
                "The system is accepted by the stakeholders as fully satisfying the requirements.\n" +
                "@\n" +
                "Software System\n" +
                "Solution\n" +
                "A system made up of software,hardware,and data that provides its primary value by the execution of the software.\n" +
                "A software system can be part of a larger software,hardware,business,or social solution.\n" +
                "\n" +
                "Architecture\n" +
                "Selected An architecture has been selected that addresses the key technical risks and any applicable organizational constraints.\n" +
                "The criteria to be used when selecting the architecture have been agreed on.\n" +
                "Hardware platforms have been identified.\n" +
                "Programming languages and technologies to be used have been selected.\n" +
                "System boundary is known.\n" +
                "Significant decisions about the organization of the system have been made.\n" +
                "Buy,build,and reuse decisions have been made.\n" +
                "Key technical risks agreed to.\n" +
                "\n" +
                "Demonstrable\n" +
                "An executable version of the system is available that demonstrates the architecture is fit for purpose and supports testing.\n" +
                "Key architectural characteristics have been demonstrated.\n" +
                "The system can be exercised and its performance can be measured.\n" +
                "Critical hardware configurations have been demonstrated.\n" +
                "Critical interfaces have been demonstrated.\n" +
                "The integration with other existing systems has been demonstrated.\n" +
                "The relevant stakeholders agree that the demonstrated architecture is appropriate.\n" +
                "\n" +
                "Usable\n" +
                "The system is usable and demonstrates all of the quality characteristics of an operational system.\n" +
                "The system can be operated by stakeholders who use it.\n" +
                "The functionality provided by the system has been tested.\n" +
                "The performance of the system is acceptable to the stakeholders.\n" +
                "Defect levels are acceptable to the stakeholders.\n" +
                "The system is fully documented.\n" +
                "Release content is known.\n" +
                "The added value provided by the system is clear.\n" +
                "\n" +
                "Ready\n" +
                "The system (as a whole) has been accepted for deployment in a live environment.\n" +
                "Installation and other user documentation are available.\n" +
                "The stakeholder representatives accept the system as fit-for-purpose.\n" +
                "The stakeholder representatives want to make the system operational.\n" +
                "Operational support is in place.\n" +
                "\n" +
                "Operational\n" +
                "The system is in use in an operational environment.\n" +
                "The system has been made available to the stakeholders intended to use it.\n" +
                "At least one example of the system is fully operational.\n" +
                "The system is fully supported to the agreed service levels.\n" +
                "\n" +
                "Retired\n" +
                "The system is no longer supported.\n" +
                "The system has been replaced or discontinued.\n" +
                "The system is no longer supported.\n" +
                "There are no “official” stakeholders who still use the system.\n" +
                "Updates to the system will no longer be produced.\n" +
                "@\n" +
                "Team\n" +
                "Endeavor\n" +
                "A group of people actively engaged in the development,maintenance,delivery,or support of a specific software system.\n" +
                "One or more teams plan and perform the work needed to create,update,and/or change the software system.\n" +
                "\n" +
                "Seeded\n" +
                "The team's mission is clear and the know-how needed to grow the team is in place.\n" +
                "The team mission has been defined in terms of the opportunities and outcomes.\n" +
                "Constraints on the team’s operation are known.\n" +
                "Mechanisms to grow the team are in place.\n" +
                "The composition of the team is defined.\n" +
                "Any constraints on where and how the work is carried out are defined.\n" +
                "The team’s responsibilities are outlined.\n" +
                "The level of team commitment is clear.\n" +
                "Required competencies are identified.\n" +
                "The team size is determined.\n" +
                "Governance rules are defined.\n" +
                "Leadership model is selected.\n" +
                "\n" +
                "Formed\n" +
                "The team has been populated with enough committed people to start the mission.\n" +
                "Individual responsibilities are understood.\n" +
                "Enough team members have been recruited to enable the work to progress.\n" +
                "Every team member understands how the team is organized and what their individual role is.\n" +
                "All team members understand how to perform their work.\n" +
                "The team members have met (perhaps virtually) and are beginning to get to know each other.\n" +
                "The team members understand their responsibilities and how they align with their competencies.\n" +
                "Team members are accepting work.\n" +
                "Any external collaborators (organizations,teams and individuals) are identified.\n" +
                "Team communication mechanisms have been defined.\n" +
                "Each team member commits to working on the team as defined.\n" +
                "\n" +
                "Collaborating\n" +
                "The team members are working together as one unit.\n" +
                "The team is working as one cohesive unit.\n" +
                "Communication within the team is open and honest.\n" +
                "The team is focused on achieving the team mission.\n" +
                "The team members know each other.\n" +
                "\n" +
                "Performing\n" +
                "The team is working effectively and efficiently.\n" +
                "The team consistently meets its commitments.\n" +
                "The team continuously adapts to the changing context.\n" +
                "The team identifies and addresses problems without outside help.\n" +
                "Effective progress is being achieved with minimal avoidable backtracking and reworking.\n" +
                "Wasted work,and the potential for wasted work are continuously eliminated.\n" +
                "\n" +
                "Adjourned\n" +
                "The team is no longer accountable for carrying out its mission.\n" +
                "The team responsibilities have been handed over or fulfilled.\n" +
                "The team members are available for assignment to other teams.\n" +
                "No further effort is being put in by the team to complete the mission.\n" +
                "@\n" +
                "Work\n" +
                "Endeavor\n" +
                "Activity involving mental or physical effort done in order to achieve a result.\n" +
                "In the context of software engineering,work is everything that the team does to meet the goals of producing a software system matching the requirements and addressing the opportunity presented by the stakeholders. The work is guided by the practices that make up the team’s way-of-working.\n" +
                "\n" +
                "Initiated\n" +
                "The work has been requested.\n" +
                "The result required of the work being initiated is clear.\n" +
                "Any constraints on the work’s performance are clearly identified.\n" +
                "The stakeholders that will fund the work are known.\n" +
                "The initiator of the work is clearly identified.\n" +
                "The stakeholders that will accept the results are known.\n" +
                "The source of funding is clear.\n" +
                "The priority of the work is clear.\n" +
                "\n" +
                "Prepared\n" +
                "All pre-conditions for starting the work have been met.\n" +
                "Commitment is made.\n" +
                "Cost and effort of the work are estimated.\n" +
                "Resource availability is understood.\n" +
                "Governance policies and procedures are clear.\n" +
                "Risk exposure is understood.\n" +
                "Acceptance criteria are defined and agreed with client.\n" +
                "The work is broken down sufficiently for productive work to start.\n" +
                "Tasks have been identified and prioritized by the team and stakeholders.\n" +
                "A credible plan is in place.\n" +
                "Funding to start the work is in place.\n" +
                "The team or at least some of the team members are ready to start the work.\n" +
                "Integration and delivery points are defined.\n" +
                "\n" +
                "Started\n" +
                "The work is proceeding.\n" +
                "Development work has been started.\n" +
                "Work progress is monitored.\n" +
                "The work is being broken down into actionable work items with clear definitions of done.\n" +
                "Team members are accepting and progressing tasks.\n" +
                "\n" +
                "Under Control\n" +
                "The work is going well,risks are under control,and productivity levels are sufficient to achieve a satisfactory result.\n" +
                "Tasks are being completed.\n" +
                "Unplanned work is under control.\n" +
                "Risks are under control as the impact if they occur and the likelihood of them occurring have been\n" +
                "reduced to acceptable levels.\n" +
                "Estimates are revised to reflect the team’s performance.\n" +
                "Measures are available to show progress and velocity.\n" +
                "Re-work is under control.\n" +
                "Tasks are consistently completed on time and within their estimates.\n" +
                "\n" +
                "Concluded\n" +
                "The work to produce the results has been concluded.\n" +
                "All outstanding tasks are administrative housekeeping or related to preparing the next piece of\n" +
                "work.\n" +
                "Work results have been achieved.\n" +
                "The stakeholder(s) has accepted the resulting software system.\n" +
                "\n" +
                "Closed\n" +
                "All remaining housekeeping tasks have been completed and the work has been officially closed.\n" +
                "Lessons learned have been itemized,recorded and discussed.\n" +
                "Metrics have been made available.\n" +
                "Everything has been archived.\n" +
                "The budget has been reconciled and closed.\n" +
                "The team has been released.\n" +
                "There are no outstanding,uncompleted tasks.\n" +
                "@\n" +
                "Way-of-Working\n" +
                "Endeavor\n" +
                "The tailored set of practices and tools used by a team to guide and support their work.\n" +
                "The team evolves their way of working alongside their understanding of their mission and their working environment. As their work proceeds they continually reflect on their way of working and adapt it to their current context,if necessary.\n" +
                "\n" +
                "Principles Established\n" +
                "The principles,and constraints,that shape the way-of-working are established.\n" +
                "Principles and constraints are committed to by the team.\n" +
                "Principles and constraints are agreed to by the stakeholders.\n" +
                "The tool needs of the work and its stakeholders are agreed.\n" +
                "A recommendation for the approach to be taken is available.\n" +
                "The context within which the team will operate is understood.\n" +
                "The constraints that apply to the selection,acquisition and use of practices and tools are known.\n" +
                "\n" +
                "Foundation Established\n" +
                "The key practices,and tools,that form the foundation of the way of working are selected and ready for use.\n" +
                "The key practices and tools that form the foundation of the way-of-working are selected.\n" +
                "Enough practices for work to start are agreed to by the team.\n" +
                "All non-negotiable practices and tools have been identified.\n" +
                "The gaps that exist between the practices and tools that are needed and the practices and tools that are available have been analyzed and understood.\n" +
                "The capability gaps that exist between what is needed to execute the desired way of working and the capability levels of the team have been analyzed and understood.\n" +
                "The selected practices and tools have been integrated to form a usable way-of-working.\n" +
                "\n" +
                "In Use\n" +
                "Some members of the team are using,and adapting,the way-of-working.\n" +
                "The practices and tools are being used to do real work.\n" +
                "The use of the practices and tools selected are regularly inspected.\n" +
                "The practices and tools are being adapted to the team’s context.\n" +
                "The use of the practices and tools is supported by the team.\n" +
                "Procedures are in place to handle feedback on the team’s way of working.\n" +
                "The practices and tools support team communication and collaboration.\n" +
                "\n" +
                "In Place\n" +
                "All team members are using the way of working to accomplish their work.\n" +
                "The practices and tools are being used by the whole team to perform their work.\n" +
                "All team members have access to the practices and tools required to do their work.\n" +
                "The whole team is involved in the inspection and adaptation of the way-of-working.\n" +
                "\n" +
                "Working well\n" +
                "The team's way of working is working well for the team.\n" +
                "Team members are making progress as planned by using and adapting the way-of-working to suit their current context.\n" +
                "The team naturally applies the practices without thinking about them\n" +
                "The tools naturally support the way that the team works.\n" +
                "The team continually tunes their use of the practices and tools.\n" +
                "\n" +
                "Retired\n" +
                "The way of working is no longer in use by the team.\n" +
                "The team’s way of working is no longer being used.\n" +
                "Lessons learned are shared for future use.";

        String[] eachAlphas = alphasString.split("@\n");

        Alpha alpha = null;
        State state = null;
        CheckPoint checkPoint = null;

        for (String alphaStr : eachAlphas) {
            String[] alphaStarArr = alphaStr.split("\n\n");
            for (int i = 0; i < alphaStarArr.length; i++) {
                String[] temp = alphaStarArr[i].split("\n");
                if (i == 0) {
                    alpha = createAlpha(temp[i], temp[i + 1], temp[i + 2], temp[i + 3]);
                    alpha.setStates(new ArrayList<State>());
                    continue;
                } else {
                    for (int j = 0; j < temp.length; j++) {
                        if (j == 0) {
                            state = createState(temp[j], temp[j + 1]);
                            state.setCheckPoints(new ArrayList<CheckPoint>());
                            j++;
                            continue;
                        } else {
                            checkPoint = createCheckpoint(temp[j]);
                            state.getCheckPoints().add(checkPoint);
                        }
                    }
                    alpha.getStates().add(state);
                }
            }
            ElementView view = alpha.createView();
            view.fill(((KernelLanguageViewable) view).createKernelSymbol());
            view.setLabel(alpha.getName());
            alpha.setElementView(view);
            alphas.add(alpha);
        }
        return alphas;
    }

    private Alpha createAlpha(String name, String concern, String briefDescription, String description) {
        Alpha alpha = new Alpha();
        alpha.setName(name);
        alpha.setConcern(concern);
        alpha.setBriefDescription(briefDescription);
        alpha.setDescription(description);
        return alpha;
    }

    private State createState(String name, String description) {
        State state = new State();
        state.setName(name);
        state.setDescription(description);
        return state;
    }

    private CheckPoint createCheckpoint(String name) {
        CheckPoint checkPoint = new CheckPoint();
        checkPoint.setName(name);
        return checkPoint;
    }

    private List<ActivitySpace> createKernelActivitySpaces() {
        List<ActivitySpace> activitySpaces = new ArrayList<>();
        String kkk = "Explore Possibilities\n" +
                "Customer\n" +
                "Explore the possibilities presented by the creation of a new or improved software system. This includes the analysis of the opportunity to be addressed and the identification of the stakeholders.\n" +
                "\n" +
                "Input\n" +
                "None\n" +
                "\n" +
                "Completion Criteria\n" +
                "Stakeholders::Recognized,Opportunity::Identified,Opportunity::Solution Needed,Opportunity::Value Established.\n" +
                "@\n" +
                "Understand Stakeholder Needs\n" +
                "Customer\n" +
                "Engage with the stakeholders to understand their needs and ensure that the right results are produced. This includes identifying and working with the stakeholder representatives to progress the opportunity.\n" +
                "\n" +
                "Input\n" +
                "Stakeholders,Opportunity,Requirements,Software System\n" +
                "\n" +
                "Completion Criteria\n" +
                "Stakeholders::Represented,Stakeholders::Involved,Stakeholders::In Agreement,Opportunity::Viable\n" +
                "@\n" +
                "Ensure Stakeholder Satisfaction\n" +
                "Customer\n" +
                "Share the results of the development work with the stakeholders to gain their acceptance of the system produced and verify that the opportunity has been successfully addressed.\n" +
                "\n" +
                "Input\n" +
                "Stakeholders,Opportunity,Requirements,Software System\n" +
                "\n" +
                "Completion Criteria\n" +
                "Stakeholders::Satisfied for Deployment,Opportunity::Addressed\n" +
                "@\n" +
                "Use the System\n" +
                "Customer\n" +
                "Observe the use of the system in an operational environment and how it benefits the stakeholders.\n" +
                "\n" +
                "Input\n" +
                "Stakeholders,Opportunity,Requirements,Software System\n" +
                "\n" +
                "Completion Criteria\n" +
                "Stakeholders::Satisfied in Use,Opportunity::Benefit Accrued\n" +
                "@\n" +
                "Understand the Requirements\n" +
                "Solution\n" +
                "SolutionEstablish a shared understanding of what the system to be produced must do.\n" +
                "\n" +
                "Input\n" +
                "Stakeholders,Opportunity,Requirements,Software System,Work,Way-of-Working\n" +
                "\n" +
                "Completion Criteria\n" +
                "Requirements::Conceived,Requirements::Bounded,Requirements::Coherent\n" +
                "@\n" +
                "Shape the System\n" +
                "Solution\n" +
                "Shape the system so that it is easy to develop,change,and maintain and can cope with current and expected future demands. This includes the overall design and architecting of the system to be produced.\n" +
                "\n" +
                "Input\n" +
                "Stakeholders,Opportunity,Requirements,Software System,Work,Way-of-Working\n" +
                "Completion Criteria\n" +
                "Requirements::Acceptable,Software System::Architecture Selected\n" +
                "@\n" +
                "Implement the System\n" +
                "Solution\n" +
                "Build a system by implementing,testing,and integrating one or more system elements; this includes bug fixing and unit testing.\n" +
                "\n" +
                "Input\n" +
                "Requirements,Software System,Way-of-Working\n" +
                "\n" +
                "Completion Criteria\n" +
                "Software System::Demonstrable,Software System::Usable,Software System::Ready\n" +
                "@\n" +
                "Test the System\n" +
                "Solution\n" +
                "Verify that the system produced meets the stakeholders' requirements\n" +
                "\n" +
                "Input\n" +
                "Requirements,Software System,Way-of-Working\n" +
                "\n" +
                "Completion Criteria\n" +
                "Requirements::Acceptable Requirements::Fulfilled,Software System::Demonstrable,Software System::Usable,Software System::Ready\n" +
                "@\n" +
                "Deploy the System\n" +
                "Solution\n" +
                "Take the tested system and make it available for use outside the development team.\n" +
                "\n" +
                "Input\n" +
                "Stakeholders,Software System,Way-of-Working\n" +
                "Completion Criteria\n" +
                "Software System::Operational\n" +
                "@\n" +
                "Operate the System\n" +
                "Solution\n" +
                "Support the use of the software system in the live environment.\n" +
                "\n" +
                "Input\n" +
                "Stakeholders,Opportunity,Requirements,Software System,Way-of-Working\n" +
                "Completion Criteria\n" +
                "Software System::Retired\n" +
                "@\n" +
                "Prepare to do the Work\n" +
                "Endeavor\n" +
                "Set up the team and its working environment. Understand and commit to completing the work.\n" +
                "\n" +
                "Input\n" +
                "Stakeholders,Opportunity,Requirements\n" +
                "Completion Criteria\n" +
                "Team::Seeded,Way of Working::Principles Established,Way of Working::Foundation Established,Work::Initiated,Work::Prepared\n" +
                "@\n" +
                "Coordinate Activity\n" +
                "Endeavor\n" +
                "Coordinate and direct the team’s work. This includes all ongoing planning and replanning of the work,and adding any additional resources needed to complete the formation of the team.\n" +
                "\n" +
                "Input\n" +
                "Requirements,Team,Work,Way of Working\n" +
                "Completion Criteria\n" +
                "Team::Formed,Work::Started,Work::Under Control\n" +
                "@\n" +
                "Support the Team\n" +
                "Endeavor\n" +
                "Help the team members to help themselves,collaborate and improve their way of working.\n" +
                "\n" +
                "Input\n" +
                "Team,Work,Way of Working\n" +
                "Completion Criteria\n" +
                "Team::Collaborating,Way of Working::In Use,Way of Working::In Place\n" +
                "@\n" +
                "Track Progress\n" +
                "Endeavor\n" +
                "Measure and assess the progress made by the team.\n" +
                "\n" +
                "Input\n" +
                "Requirements,Team,Work,Way of Working\n" +
                "Completion Criteria\n" +
                "Team::Performing,Way of Working::Working Well,Work::Under Control,Work::Concluded\n" +
                "@\n" +
                "Stop the Work\n" +
                "Endeavor\n" +
                "Shut down the software engineering endeavor and hand over the team’s responsibilities.\n" +
                "\n" +
                "Input\n" +
                "Requirements,Team,Work,Way of Working\n" +
                "Completion Criteria\n" +
                "Team::Adjourned,Way of Working::Retired,Work::Closed";
        String[] eachActivitySpace = kkk.split("@\n");

        ActivitySpace activitySpace = null;
        Alpha alpha = null;
        CompletionCriterion completionCriterion = null;

        for (String activitySpaceStr : eachActivitySpace) {
            String[] activitySpaceArr = activitySpaceStr.split("\n\n");
            for (int i = 0; i < activitySpaceArr.length; i++) {
                String[] temp = activitySpaceArr[i].split("\n");
                if (i == 0) {
                    activitySpace = createActivitySpace(temp[i], temp[i + 1], temp[i + 2]);
                    activitySpace.setInputList(new ArrayList<Alpha>());
                    activitySpace.setCompletionCriteria(new ArrayList<CompletionCriterion>());
                    continue;
                } else {
                    for (int j = 0; j < temp.length; j++) {
                        if ("Input".equals(temp[j])) {
                            if (!"None".equals(temp[j + 1])) {
                                String[] inputAlphas = temp[1].split(",");
                                for (String inputAlpha : inputAlphas) {
                                    alpha = createAlpha(inputAlpha, "", "", "");
                                    activitySpace.getInputList().add(alpha);
                                }
                            }
                            j++;
                            continue;
                        } else {
                            String[] completionCriteria = temp[j + 1].split(",");

                            for (String completionCriterionStr : completionCriteria) {
                                String[] criteronTemp = completionCriterionStr.split("::");

                                completionCriterion = createCompletionCriterion(criteronTemp[0], criteronTemp[1]);
                                activitySpace.getCompletionCriteria().add(completionCriterion);
                            }
                            j++;
                        }
                    }
                }
            }
            ElementView view = activitySpace.createView();
            view.fill(((KernelLanguageViewable) view).createKernelSymbol());
            view.setLabel(activitySpace.getName());
            activitySpace.setElementView(view);
            activitySpaces.add(activitySpace);
        }
        return activitySpaces;

    }

    private ActivitySpace createActivitySpace(String name, String concern, String description) {
        ActivitySpace activitySpace = new ActivitySpace();
        activitySpace.setName(name);
        activitySpace.setConcern(concern);
        activitySpace.setDescription(description);
        return activitySpace;
    }

    private CompletionCriterion createCompletionCriterion(String alphaName, String stateName) {
        CompletionCriterion completionCriterion = new CompletionCriterion();
        State state = createState(stateName, "");
        Alpha alpha = createAlpha(alphaName, "", "", "");
        state.setParentAlpha(alpha);
        completionCriterion.setState(state);
        return completionCriterion;
    }

    private List<Competency> createKernelCompetencies() {
        List<Competency> competencies = new ArrayList<>();
        String competenciesStr = "Stakeholder Representation\n" +
                "Customer\n" +
                "This competency encapsulates the ability to gather, communicate, and balance the needs of other stakeholders and accurately represent their views.\n" +
                "The stakeholder representation competency is the empathic ability to stand in for and accurately reflect the opinions, rights, and obligations of other stakeholders.\n" +
                "\n" +
                "1::Assists::Demonstrates a basic understanding of the concepts and can follow instructions.\n" +
                "2::Applies::Able to apply the concepts in simple contexts by routinely applying the experience gained so far.\n" +
                "3::Masters::Able to apply the concepts in most contexts and has the experience to work without supervision.\n" +
                "4::Adapts::Able to apply judgment on when and how to apply the concepts to more complex contexts. Can enable others to apply the concepts.\n" +
                "5::Innovates::A recognized expert, able to extend the concepts to new contexts and inspire others.\n" +
                "@\n" +
                "Analysis\n" +
                "Solution\n" +
                "This competency encapsulates the ability to understand opportunities and their related stakeholder needs, and transform them into an agreed and consistent set of requirements.\n" +
                "The analysis competency is the deductive ability to understand the situation, context, concepts and problems, identify appropriate high-level solutions, and evaluate and draw conclusions by applying logical thinking.\n" +
                "\n" +
                "1::Assists::Demonstrates a basic understanding of the concepts and can follow instructions.\n" +
                "2::Applies::Able to apply the concepts in simple contexts by routinely applying the experience gained so far.\n" +
                "3::Masters::Able to apply the concepts in most contexts and has the experience to work without supervision.\n" +
                "4::Adapts::Able to apply judgment on when and how to apply the concepts to more complex contexts. Can enable others to apply the concepts.\n" +
                "5::Innovates::A recognized expert, able to extend the concepts to new contexts and inspire others.\n" +
                "@\n" +
                "Development\n" +
                "Solution\n" +
                "This competency encapsulates the ability to design and program effective software systems following the standards and norms agreed by the team.\n" +
                "The development competency is the mental ability to conceive and produce a software system, or one of its elements, for a specific function or end. It enables a team to produce software systems that meet the requirements.\n" +
                "\n" +
                "1::Assists::Demonstrates a basic understanding of the concepts and can follow instructions.\n" +
                "2::Applies::Able to apply the concepts in simple contexts by routinely applying the experience gained so far.\n" +
                "3::Masters::Able to apply the concepts in most contexts and has the experience to work without supervision.\n" +
                "4::Adapts::Able to apply judgment on when and how to apply the concepts to more complex contexts. Can enable others to apply the concepts.\n" +
                "5::Innovates::A recognized expert, able to extend the concepts to new contexts and inspire others.\n" +
                "@\n" +
                "Testing\n" +
                "Solution\n" +
                "This competency encapsulates the ability to test a system, verifying that it is usable and that it meets the requirements.\n" +
                "The testing competency is an observational, comparative, detective, and destructive ability that enables the system to be tested.\n" +
                "\n" +
                "1::Assists::Demonstrates a basic understanding of the concepts and can follow instructions.\n" +
                "2::Applies::Able to apply the concepts in simple contexts by routinely applying the experience gained so far.\n" +
                "3::Masters::Able to apply the concepts in most contexts and has the experience to work without supervision.\n" +
                "4::Adapts::Able to apply judgment on when and how to apply the concepts to more complex contexts. Can enable others to apply the concepts.\n" +
                "5::Innovates::A recognized expert, able to extend the concepts to new contexts and inspire others.\n" +
                "@\n" +
                "Leadership\n" +
                "Endeavor\n" +
                "This competency enables a person to inspire and motivate a group of people to achieve a successful conclusion to their work and to meet their objectives.\n" +
                " \n" +
                "\n" +
                "1::Assists::Demonstrates a basic understanding of the concepts and can follow instructions.\n" +
                "2::Applies::Able to apply the concepts in simple contexts by routinely applying the experience gained so far.\n" +
                "3::Masters::Able to apply the concepts in most contexts and has the experience to work without supervision.\n" +
                "4::Adapts::Able to apply judgment on when and how to apply the concepts to more complex contexts. Can enable others to apply the concepts.\n" +
                "5::Innovates::A recognized expert, able to extend the concepts to new contexts and inspire others.\n" +
                "@\n" +
                "Management\n" +
                "Endeavor\n" +
                "This competency encapsulates the ability to coordinate, plan, and track the work done by a team.\n" +
                "The management competency is the administrative and organizational ability that enables the right things to be done at the right time to maximize a team’s chances of success.\n" +
                "\n" +
                "1::Assists::Demonstrates a basic understanding of the concepts and can follow instructions.\n" +
                "2::Applies::Able to apply the concepts in simple contexts by routinely applying the experience gained so far.\n" +
                "3::Masters::Able to apply the concepts in most contexts and has the experience to work without supervision.\n" +
                "4::Adapts::Able to apply judgment on when and how to apply the concepts to more complex contexts. Can enable others to apply the concepts.\n" +
                "5::Innovates::A recognized expert, able to extend the concepts to new contexts and inspire others.";
        String[] eachCompetency = competenciesStr.split("@\n");

        Competency competency = null;
        CompetencyLevel competencyLevel = null;

        for (String competencyStr : eachCompetency) {
            String[] competencyStrArr = competencyStr.split("\n\n");
            for (int i = 0; i < competencyStrArr.length; i++) {
                String[] temp = competencyStrArr[i].split("\n");
                if (i == 0) {
                    competency = createComptency(temp[i], temp[i + 1], temp[i + 2], temp[i + 3]);
                    competency.setCompetencyLevels(new ArrayList<CompetencyLevel>());
                    continue;
                } else {
                    for (int j = 0; j < temp.length; j++) {
                        String[] tempArr = temp[j].split("::");
                        competencyLevel = createCompetencyLevel(tempArr[1], tempArr[2], Integer.valueOf(tempArr[0]));
                        competency.getCompetencyLevels().add(competencyLevel);
                    }
                }
            }
            ElementView view = competency.createView();
            view.fill(((KernelLanguageViewable) view).createKernelSymbol());
            view.setLabel(competency.getName());
            competency.setElementView(view);
            competencies.add(competency);
        }
        return competencies;

    }

    private Competency createComptency(String name, String concern, String briefDescription, String description) {
        Competency competency = new Competency();
        competency.setName(name);
        competency.setConcern(concern);
        competency.setBriefDescription(briefDescription);
        competency.setDescription(description);

        return competency;
    }

    private CompetencyLevel createCompetencyLevel(String name, String briefDescription, int level) {
        CompetencyLevel competencyLevel = new CompetencyLevel();
        competencyLevel.setName(name);
        competencyLevel.setBriefDescription(briefDescription);
        competencyLevel.setLevel(level);
        return competencyLevel;
    }
}
