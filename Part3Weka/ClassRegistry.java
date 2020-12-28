package Part3Weka;
import A1Java.*;
import Part2MVC.*;
import gradingTools.comp524f20.assignment1.SocialDistanceClassRegistry;


public class ClassRegistry implements SocialDistanceClassRegistry{

	@Override
	public Class<?> getBasicSocialDistanceUtility() {
		return SocialDistancingUtility.class;
	}

	@Override
	public Class<?> getSocialDistancDerivingModel() {
		return DerivedModel.class;
	}

	@Override
	public Class<?> getSocialDistancInferringModel() {
		return WekaModel.class;
	}

	@Override
	public Class<?> getSocialDistanceBasicModel() {
		return GivenModel.class;
	}

	@Override
	public Class<?> getSocialDistanceClassifierFactory() {
		return SocialDistanceClassifierFactory.class;
	}

	@Override
	public Class<?> getSocialDistanceController() {
		return Controller.class;
	}

	@Override
	public Class<?> getSocialDistanceControllerFactory() {
		return ControllerFactory.class;
	}

	@Override
	public Class<?> getSocialDistanceInterpolatingModel() {
		return InterpolatedModel.class;
	}

	@Override
	public Class<?> getSocialDistanceMVCBasicMain() {
		return GivenMain.class;
	}

	@Override
	public Class<?> getSocialDistanceMVCDerivingMain() {
		return DerivedMain.class;
	}

	@Override
	public Class<?> getSocialDistanceMVCInferringMain() {
		return InferringMain.class;
	}

	@Override
	public Class<?> getSocialDistanceMVCInterpolatingMain() {
		return InterpolatedMain.class;
	}

	@Override
	public Class<?> getSocialDistanceModelFactory() {
		return ModelFactory.class;
	}

	@Override
	public Class<?> getSocialDistanceUilityTesterMain() {
		return SocialDistanceUtilityTesterMain.class;
	}

	@Override
	public Class<?> getSocialDistanceView() {
		return ConsoleView.class;
	}

	@Override
	public Class<?> getSocialDistanceViewFactory() {
		return ViewFactory.class;
	}


}
